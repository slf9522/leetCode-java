//Given an array of integers nums sorted in ascending order, find the starting a
//nd ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums is a non-decreasing array. 
// -109 <= target <= 109 
// 
// Related Topics Array Binary Search 
// 👍 6702 👎 222


package leetcode.editor.en;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] res = solution.searchRange(new int[]{1}, 0);
        for (int i = 0; i < 2; i++) {
            System.out.println(res[i]);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] res = new int[]{-1, -1};
            if (nums.length == 0) {
                return res;
            }

            int mid = nums.length / 2;
            int left = 0;
            int right = nums.length - 1;
            // 找最左边的数
            while (left <= right) {
                int tmp = nums[mid];
                // 取右半边
                if (target > tmp) {
                    left = mid + 1;
                    mid = (left + right) / 2;
//                    取左半边，找最左边的数
                } else {
                    right = mid - 1;
                    mid = (left + right) / 2;
                }
            }

            res[0] = left >= 0 && left < nums.length && nums[left] == target ? left : -1;

            mid = nums.length / 2;
            left = 0;
            right = nums.length - 1;
            while (left <= right) {
                int tmp = nums[mid];
                // 取右半边，找最右边的数
                if (target >= tmp) {
                    left = mid + 1;
                    mid = (left + right) / 2;
//                    取左半边
                } else {
                    right = mid - 1;
                    mid = (left + right) / 2;
                }
            }

            res[1] = left - 1 >= 0 && left - 1 < nums.length && nums[left - 1] == target ? left - 1 : -1;

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}