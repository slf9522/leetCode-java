//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2650 👎 0


package leetcode.editor.cn;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author JX
 * @date 2024-03-24 14:40:52
 */
public class P34_FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P34_FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        System.out.println(solution.searchRange(new int[]{1,2,3}, 1));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = b1(nums, target, 0, nums.length - 1);
            int right = b2(nums, target, 0, nums.length - 1);
            return new int[]{left, right};
        }

        private int b1(int[] nums, int target, int lo, int hi) {
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                int v = nums[mid];
                if (target == v) {
                    hi = mid - 1;
                } else if (target < v) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            if (lo >= nums.length || nums[lo] != target) return -1;
            return lo;
        }

        private int b2(int[] nums, int target, int lo, int hi) {
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                int v = nums[mid];
                if (target == v) {
                    lo = mid + 1;
                } else if (target < v) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            if (hi < 0 || nums[hi] != target) return -1;
            return hi;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}