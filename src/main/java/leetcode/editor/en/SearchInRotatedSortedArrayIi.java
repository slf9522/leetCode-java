//There is an integer array nums sorted in non-decreasing order (not necessarily
// with distinct values). 
//
// Before being passed to your function, nums is rotated at an unknown pivot ind
//ex k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1]
//, ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0
//,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,
//2,4,4]. 
//
// Given the array nums after the rotation and an integer target, return true if
// target is in nums, or false if it is not in nums. 
//
// You must decrease the overall operation steps as much as possible. 
//
// 
// Example 1: 
// Input: nums = [2,5,6,0,0,1,2], target = 0
//Output: true
// Example 2: 
// Input: nums = [2,5,6,0,0,1,2], target = 3
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -104 <= nums[i] <= 104 
// nums is guaranteed to be rotated at some pivot. 
// -104 <= target <= 104 
// 
//
// 
// Follow up: This problem is similar to Search in Rotated Sorted Array, but num
//s may contain duplicates. Would this affect the runtime complexity? How and why?
// 
// Related Topics Array Binary Search 
// 👍 2806 👎 619


package leetcode.editor.en;

import java.util.Arrays;

public class SearchInRotatedSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArrayIi().new Solution();
        System.out.println(solution.search(new int[]{1, 0, 1, 1, 1}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;

            // 只有当相等时，能够找完所有的元素
            while (left <= right) {
//                left + (right - left)/2 防止溢出
                int mid = (left + right) / 2;
                if (nums[mid] == target) return true;

                while (left < mid && nums[left] == nums[mid]) left++;

//                左半边有序
                if (nums[left] <= nums[mid]) {
                    if (target >= nums[left] && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
//                右半边有序
                } else {
                    if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return false;
        }

        // 二分法写法复习
        public boolean search2(int[] nums, int target) {
            int left = 0, right = nums.length;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) return true;
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}