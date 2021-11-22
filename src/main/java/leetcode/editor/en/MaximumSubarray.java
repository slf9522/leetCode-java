//Given an integer array nums, find the contiguous subarray (containing at least
// one number) which has the largest sum and return its sum. 
//
// A subarray is a contiguous part of an array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: nums = [5,4,-1,7,8]
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 
//
// 
// Follow up: If you have figured out the O(n) solution, try coding another solu
//tion using the divide and conquer approach, which is more subtle. 
// Related Topics Array Divide and Conquer Dynamic Programming 
// 👍 15945 👎 749


package leetcode.editor.en;

public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        System.out.println(solution.maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // dp 解法
        public int maxSubArray(int[] nums) {
            int[] sum = new int[nums.length];
            sum[0] = nums[0];
            int res = sum[0];
            // 以i结尾的最大值
            for (int i = 1; i < nums.length; i++) {
                sum[i] = sum[i - 1] < 0 ? nums[i] : sum[i - 1] + nums[i];
                res = Math.max(res, sum[i]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}