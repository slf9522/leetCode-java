//给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。 
//
// 题目数据保证答案符合 32 位整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3], target = 4
//输出：7
//解释：
//所有可能的组合为：
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//请注意，顺序不同的序列被视作不同的组合。
// 
//
// 示例 2： 
//
// 
//输入：nums = [9], target = 3
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 1000 
// nums 中的所有元素 互不相同 
// 1 <= target <= 1000 
// 
//
// 
//
// 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？ 
//
// Related Topics 数组 动态规划 👍 986 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 组合总和 Ⅳ
 *
 * @author JX
 * @date 2024-04-22 20:40:27
 */
public class P377_CombinationSumIv {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P377_CombinationSumIv().new Solution();
        System.out.println(solution.combinationSum4(new int[]{1, 2, 3}, 4));
        System.out.println(solution.combinationSum4(new int[]{9}, 3));

    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int combinationSum4(int[] nums, int target) {
            Arrays.sort(nums);
            if (nums[0] > target) return 0;
            int[] dp = new int[target + 1];
            // num[0]表示target=0，同时不需要选择任何一个元素
            dp[0] = 1;
            dp[nums[0]] = 1;
            for (int start = nums[0] + 1; start <= target; start++) {
                for (int i = 0; i < nums.length; i++) {
                    int v = nums[i];
                    // start == v 时用dp[0]的值
                    if (start - v >= 0) {
                        dp[start] += dp[start - v];
                    }
                }
            }
            return dp[target];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}