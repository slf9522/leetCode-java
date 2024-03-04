//You are given an integer array nums. You are initially positioned at the 
//array's first index, and each element in the array represents your maximum jump 
//length at that position. 
//
// Return true if you can reach the last index, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum 
//jump length is 0, which makes it impossible to reach the last index.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// Related Topics Array Dynamic Programming Greedy 👍 18765 👎 1162


package leetcode.editor.en;

/**
 * Jump Game
 *
 * @author JX
 * @date 2024-03-04 15:22:25
 */
public class P55_JumpGame {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P55_JumpGame().new Solution();
        System.out.println(solution.canJump(new int[]{2,3,1,1,4}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            int l = nums.length;
            boolean[] dp = new boolean[l];
            dp[0] = true;

            for (int i = 1; i < l; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] >= i - j) {
                        dp[i] = dp[i] | dp[j];
                    }
                    if(dp[i]) break;
                }
            }
            return dp[l-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
