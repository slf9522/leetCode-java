//Given an integer array nums, return the length of the longest strictly 
//increasing subsequence. 
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
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
// Follow up: Can you come up with an algorithm that runs in O(n log(n)) time 
//complexity? 
//
// Related Topics Array Binary Search Dynamic Programming 👍 20378 👎 416


package leetcode.editor.en;

import java.util.Arrays;

/**
 * Longest Increasing Subsequence
 * @author DY
 * @date 2024-02-14 13:23:35
 */
public class P300_LongestIncreasingSubsequence{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P300_LongestIncreasingSubsequence().new Solution();
         System.out.println(solution.lengthOfLIS(new int[]{0,1,0,3,2,3}));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
		int res = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i-1; j >=0 ; j--) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res= Math.max(res, dp[i]);
                }
            }
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
