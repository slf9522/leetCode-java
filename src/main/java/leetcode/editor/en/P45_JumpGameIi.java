//You are given a 0-indexed array of integers nums of length n. You are 
//initially positioned at nums[0]. 
//
// Each element nums[i] represents the maximum length of a forward jump from 
//index i. In other words, if you are at nums[i], you can jump to any nums[i + j] 
//where: 
//
// 
// 0 <= j <= nums[i] and 
// i + j < n 
// 
//
// Return the minimum number of jumps to reach nums[n - 1]. The test cases are 
//generated such that you can reach nums[n - 1]. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 
//step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,3,0,1,4]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// It's guaranteed that you can reach nums[n - 1]. 
// 
//
// Related Topics Array Dynamic Programming Greedy 👍 14118 👎 533


package leetcode.editor.en;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Jump Game II
 *
 * @author JX
 * @date 2024-03-04 15:29:38
 */
public class P45_JumpGameIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P45_JumpGameIi().new Solution();
        System.out.println(solution.jump(new int[]{2,3,1,1,4}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump(int[] nums) {
            int l = nums.length;
            int[] dp = new int[l];
            Arrays.fill(dp, 10001);
            dp[0] = 0;

            for (int i = 1; i < l; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] >= i - j) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
            return dp[l-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
