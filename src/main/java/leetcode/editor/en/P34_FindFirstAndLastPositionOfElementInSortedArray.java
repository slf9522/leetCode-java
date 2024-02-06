//Given an array of integers nums sorted in non-decreasing order, find the 
//starting and ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// 
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// 
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums is a non-decreasing array. 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics Array Binary Search 👍 19898 👎 482


package leetcode.editor.en;

import java.util.Arrays;

/**
 * Find First and Last Position of Element in Sorted Array
 *
 * @author DY
 * @date 2024-02-05 15:08:14
 */
public class P34_FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P34_FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        System.out.println(Arrays.toString(solution.searchRange(new int[]{}, 2)));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] res = new int[2];
            res[0] = leftBound(nums, target);
            res[1] = rightBound(nums, target);
            return res;
        }

        public int leftBound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int v = nums[mid];

                if (v == target) {
                    // 移动右边界
                    right = mid - 1;
                } else if (v < target) {
                    left = mid + 1;
                } else if (v > target) {
                    right = mid - 1;
                }
            }

            // 不断移动左边界，target比所有数都大
            if (left == nums.length) return -1;
            return nums[left] != target ? -1 : left;
        }

        public int rightBound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int v = nums[mid];

                if (v == target) {
                    // 移动左边界
                    left = mid + 1;
                } else if (v < target) {
                    left = mid + 1;
                } else if (v > target) {
                    right = mid - 1;
                }
            }

            // 不断移动有边界，target比所有数都小
            if(right < 0) return -1;
            return nums[right] != target ? -1 : right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
