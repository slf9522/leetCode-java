//You are given an integer array nums and an integer target. 
//
// You want to build an expression out of nums by adding one of the symbols '+' 
//and '-' before each integer in nums and then concatenate all the integers. 
//
// 
// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 
//and concatenate them to build the expression "+2-1". 
// 
//
// Return the number of different expressions that you can build, which evaluate
//s to target. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,1,1,1], target = 3
//Output: 5
//Explanation: There are 5 ways to assign symbols to make the sum of nums be tar
//get 3.
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// Example 2: 
//
// 
//Input: nums = [1], target = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics Array Dynamic Programming Backtracking 
// 👍 5747 👎 225


package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

/**
 * 目标和
 */
public class TargetSum {
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int findTargetSumWays(int[] nums, int target) {
            return findTargetSumWays(nums, target, 0, new HashMap<>());
        }

        /**
         * 1、递归解法
         *
         * @param nums
         * @param target
         * @param i      i是递增的，所以不需要循环
         * @param map    因为不同的i为起点，可能出现相同的target，所以map的key要变一下
         * @return
         */
        public int findTargetSumWays(int[] nums, int target, int i, Map<String, Integer> map) {
            if (i == nums.length && target == 0) return 1;
            if (i == nums.length) return -1;

            String key = String.join(",", String.valueOf(i), String.valueOf(target));
            if (map.containsKey(key)) {
                return map.get(key);
            }

            int res = 0;
            int nj = nums[i];

            int n1 = findTargetSumWays(nums, target - nj, i + 1, map);
            if (n1 > 0) res += n1;

            int n2 = findTargetSumWays(nums, target + nj, i + 1, map);
            if (n2 > 0) res += n2;

            map.put(key, res);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}