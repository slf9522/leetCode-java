//Given an array of positive integers nums and a positive integer target, return
// the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, nums
//r] of which the sum is greater than or equal to target. If there is no such suba
//rray, return 0 instead. 
//
// 
// Example 1: 
//
// 
//Input: target = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: The subarray [4,3] has the minimal length under the problem const
//raint.
// 
//
// Example 2: 
//
// 
//Input: target = 4, nums = [1,4,4]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: target = 11, nums = [1,1,1,1,1,1,1,1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= target <= 109 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 105 
// 
//
// 
//Follow up: If you have figured out the O(n) solution, try coding another solut
//ion of which the time complexity is O(n log(n)). Related Topics Array Binary Sea
//rch Sliding Window Prefix Sum 
// 👍 4687 👎 155


package leetcode.editor.en;

//https://leetcode.com/problems/minimum-size-subarray-sum/discuss/59078/Accepted-clean-Java-O(n)-solution-
//(two-pointers)
//思路相同，想法简洁
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum().new Solution();
        System.out.println(solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int i = 0;
            int j = 0;

            // 循环全程记录
            int sum = 0;
//            返回值，窗口大小
            int res = Integer.MAX_VALUE;

            while (j < nums.length) {
                // 移动右侧
                while (j < nums.length && sum < target) {
                    sum += nums[j++];
                }

                //移动左侧，只有在循环内才能够更新
                while (sum >= target) {
                    res = Math.min(res, j - i);
                    sum -= nums[i++];
                }
            }
            return res == Integer.MAX_VALUE ? 0 : res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}