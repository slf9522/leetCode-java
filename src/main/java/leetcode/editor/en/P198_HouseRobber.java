//You are a professional robber planning to rob houses along a street. Each 
//house has a certain amount of money stashed, the only constraint stopping you from 
//robbing each of them is that adjacent houses have security systems connected and 
//it will automatically contact the police if two adjacent houses were broken 
//into on the same night. 
//
// Given an integer array nums representing the amount of money of each house, 
//return the maximum amount of money you can rob tonight without alerting the 
//police. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//Total amount you can rob = 1 + 3 = 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 
//(money = 1).
//Total amount you can rob = 2 + 9 + 1 = 12.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
//
// Related Topics Array Dynamic Programming 👍 20531 👎 405


package leetcode.editor.en;

/**
 * House Robber
 *
 * @author JX
 * @date 2024-03-04 11:14:16
 */
public class P198_HouseRobber {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P198_HouseRobber().new Solution();
        solution.rob(new int[]{1,2,3,1});
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            int l = nums.length;
            int[][] dp = new int[2][l + 1];
            // steal
            dp[0][0] = Integer.MIN_VALUE;
            // not steal
            dp[1][0] = 0;

            for (int i = 1; i < l + 1; i++) {
                dp[0][i] = Math.max(dp[0][i], dp[1][i - 1] + nums[i - 1]);
                for (int j = i - 1; j >= 0; j--) {
                    dp[1][i] = Math.max(dp[1][i], dp[0][j]);
                }
            }
            return Math.max(dp[0][l], dp[1][l]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
