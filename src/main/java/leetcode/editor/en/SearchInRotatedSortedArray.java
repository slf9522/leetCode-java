//There is an integer array nums sorted in ascending order (with distinct values
//). 
//
// Prior to being passed to your function, nums is rotated at an unknown pivot i
//ndex k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+
//1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, 
//[0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2]. 
//
// Given the array nums after the rotation and an integer target, return the ind
//ex of target if it is in nums, or -1 if it is not in nums. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// Example 2: 
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// Example 3: 
// Input: nums = [1], target = 0
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -104 <= nums[i] <= 104 
// All values of nums are unique. 
// nums is guaranteed to be rotated at some pivot. 
// -104 <= target <= 104 
// 
// Related Topics Array Binary Search 
// 👍 9134 👎 724


package leetcode.editor.en;

import java.util.Arrays;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        System.out.println(solution.search(new int[]{1, 3, 5}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            if (nums.length == 1) {
                return nums[0] == target ? 0 : -1;
            }

            if (nums[0] < nums[nums.length - 1]) {
                int tmp = Arrays.binarySearch(nums, 0, nums.length, target);
                return tmp < 0 ? -1 : tmp;
            }

//            找到最小值
            int mid = nums.length / 2;
            int l = 0;
            int r = nums.length - 1;
            while (nums[mid] > nums[Math.max(0, mid - 1)] && nums[mid] < nums[Math.min(nums.length - 1, mid + 1)] && l != r) {
                if (nums[mid] > nums[l]) {
                    l = mid;
                    mid = (l + r) / 2;
                } else {
                    r = mid;
                    mid = (l + r) / 2;
                }
            }
            if (nums[mid] > nums[0]) {
                if (mid == nums.length - 1) {
                    mid = 0;
                } else {
                    mid++;
                }
            }

            if (nums[mid] <= target && target <= nums[nums.length - 1]) {
                int tmp = Arrays.binarySearch(nums, mid, nums.length, target);
                return tmp < 0 ? -1 : tmp;
            }
            if (mid > 0 && nums[0] <= target && nums[mid - 1] >= target) {
                int tmp = Arrays.binarySearch(nums, 0, mid, target);
                return tmp < 0 ? -1 : tmp;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}