//Given an integer array nums, return the length of the longest strictly increas
//ing subsequence. 
//
// A subsequence is a sequence that can be derived from an array by deleting som
//e or no elements without changing the order of the remaining elements. For examp
//le, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]. 
//
// 
// Example 1: 
//
// 
//Input: nums = [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the 
//length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,0,3,2,3]
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: nums = [7,7,7,7,7,7,7]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
// Follow up: Can you come up with an algorithm that runs in O(n log(n)) time co
//mplexity? 
// Related Topics Array Binary Search Dynamic Programming 
// 👍 9834 👎 201


package leetcode.editor.en;

import java.util.Arrays;
import java.util.TreeMap;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            // nums[i], dp[i]
            TreeMap<Integer, Integer> map = new TreeMap<>();

            int res = 1;
            for (int i = 0; i < nums.length; i++) {
//                for (int j = i - 1; j >= 0; j--) {
//                    if (nums[j] < nums[i]) {
//                        dp[i] = Math.max(dp[i], dp[j] + 1);
//                    }
//                }
                int ni = nums[i];
                int max = map.headMap(ni).values().stream().max(Integer::compareTo).orElse(0);
                dp[i] = Math.max(dp[i], max + 1);
                map.put(ni, map.getOrDefault(ni, 1) < dp[i] ? dp[i] : map.getOrDefault(ni, 1));
                res = Math.max(res, dp[i]);
            }
            return res;
        }

        // 二分排序算法
    }
//leetcode submit region end(Prohibit modification and deletion)

}