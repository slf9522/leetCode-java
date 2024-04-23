//给你一个按 非递减顺序 排列的数组 nums ，返回正整数数目和负整数数目中的最大值。 
//
// 
// 换句话讲，如果 nums 中正整数的数目是 pos ，而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值。 
// 
//
// 注意：0 既不是正整数也不是负整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,-1,-1,1,2,3]
//输出：3
//解释：共有 3 个正整数和 3 个负整数。计数得到的最大值是 3 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [-3,-2,-1,0,0,1,2]
//输出：3
//解释：共有 2 个正整数和 3 个负整数。计数得到的最大值是 3 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,20,66,1314]
//输出：4
//解释：共有 4 个正整数和 0 个负整数。计数得到的最大值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2000 
// -2000 <= nums[i] <= 2000 
// nums 按 非递减顺序 排列。 
// 
//
// 
//
// 进阶：你可以设计并实现时间复杂度为 O(log(n)) 的算法解决此问题吗？ 
//
// Related Topics 数组 二分查找 计数 👍 24 👎 0


package leetcode.editor.cn;

import static java.util.Arrays.binarySearch;

/**
 * 正整数和负整数的最大计数
 *
 * @author JX
 * @date 2024-04-09 20:59:37
 */
public class P2529_MaximumCountOfPositiveIntegerAndNegativeInteger {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P2529_MaximumCountOfPositiveIntegerAndNegativeInteger().new Solution();
        System.out.println(solution.maximumCount(new int[]{-1563, -236, -114, -55, 427, 447, 687, 752, 1021, 1636}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumCount(int[] nums) {
            if (nums[0] > 0 || nums[nums.length - 1] < 0) return nums.length;
            int pos1 = bs(nums, 0); // left bound
            int pos2 = bs(nums, 1);
            return Math.max(pos1, nums.length - pos2);
        }

        private int bs(int[] nums, int target) {
            int lo = 0, hi = nums.length;
            // 左闭右开区间
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                int v = nums[mid];
                if (v < target) {
                    lo = mid + 1;
                } else if (v > target) {
                    hi = mid;
                } else {
                    hi = mid;
                }
            }
            return lo;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}