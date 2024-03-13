//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 请你实现时间复杂度为 
//O(n) 并且只使用常数级别额外空间的解决方案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
//解释：范围 [1,2] 中的数字都在数组中。 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
//解释：1 在数组中，但 2 没有。 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
//解释：最小的正数 1 没有出现。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// Related Topics 数组 哈希表 👍 2073 👎 0


package leetcode.editor.cn;

/**
 * 缺失的第一个正数
 *
 * @author JX
 * @date 2024-03-13 13:19:50
 */
public class P41_FirstMissingPositive {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P41_FirstMissingPositive().new Solution();
        System.out.println(solution.firstMissingPositive(new int[]{0, 1, 2}));
//        System.out.println(solution.firstMissingPositive(new int[]{1}));

    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int l = nums.length;
            boolean[] tmp = new boolean[l + 1];
            for (int i = 0; i < nums.length; i++) {
                int v = nums[i];
                if (v <= l && v > 0) {
                    tmp[v] = true;
                }
            }

            for (int i = 1; i < l+1; i++) {
                if (!tmp[i]) return i;
            }
            return l + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}