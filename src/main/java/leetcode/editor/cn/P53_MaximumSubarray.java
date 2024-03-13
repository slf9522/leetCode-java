//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
//
// Related Topics 数组 分治 动态规划 👍 6570 👎 0


package leetcode.editor.cn;

/**
 * 最大子数组和
 *
 * @author JX
 * @date 2024-03-13 15:40:26
 */
public class P53_MaximumSubarray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P53_MaximumSubarray().new Solution();
        System.out.println(solution.maxSubArray(new int[]{5,4,-1,7,8}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int l = nums.length;
            if (l == 1) return nums[0];
            int[] dp = new int[l + 1];
            dp[0] = 0;
            int[] sum = new int[l + 1];
            sum[0] = 0;

            int res = Integer.MIN_VALUE;
            for (int i = 1; i < l + 1; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
                dp[i] = Math.min(dp[i - 1], sum[i]);
                res = Math.max(res, sum[i] - dp[i-1]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}