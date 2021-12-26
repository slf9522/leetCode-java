//Given a non-empty array nums containing only positive integers, find if the ar
//ray can be partitioned into two subsets such that the sum of elements in both su
//bsets is equal. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,5,11,5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,5]
//Output: false
//Explanation: The array cannot be partitioned into equal sum subsets.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics Array Dynamic Programming 
// 👍 6442 👎 107


package leetcode.editor.en;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
        System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition2(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            return sum % 2 == 0 && canPartition(nums, sum / 2, 0, new HashMap<>());
        }

        // 解法1：递归
        private boolean canPartition(int[] nums, int target, int i, Map<String, Boolean> map) {

            if (i == nums.length && target != 0) return false;
            if (i < nums.length && target == nums[i]) return true;

            String key = String.join(",", String.valueOf(i), String.valueOf(target));
            if (map.containsKey(key)) return map.get(key);

            for (int j = i; j < nums.length; j++) {
                if (target - nums[j] > 0 && canPartition(nums, target - nums[j], j + 1, map)) {
                    map.put(key, true);
                    return true;
                } else if (target - nums[j] == 0) {
                    map.put(key, true);
                    return true;
                }
            }
            map.put(key, false);
            return false;
        }

        // 解法2：背包
        public boolean canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            if (sum % 2 == 1) return false;

            int target = sum / 2;
            boolean[][] dp = new boolean[nums.length + 1][target + 1];

//            dp[i][j] 标识前i个元素的和是否等于j
            for (int i = 0; i < nums.length + 1; i++) {
                dp[i][0] = true;
            }
            for (int i = 1; i < nums.length + 1; i++) {
                for (int j = 1; j < target + 1; j++) {
                    dp[i][j] = dp[i - 1][j] || (j >= nums[i - 1] && dp[i - 1][j - nums[i - 1]]);
                }
            }

            return dp[nums.length][target];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}