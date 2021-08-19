//Given a sorted array of distinct integers and a target value, return the index
// if the target is found. If not, return the index where it would be if it were i
//nserted in order. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [1,3,5,6], target = 5
//Output: 2
// Example 2: 
// Input: nums = [1,3,5,6], target = 2
//Output: 1
// Example 3: 
// Input: nums = [1,3,5,6], target = 7
//Output: 4
// Example 4: 
// Input: nums = [1,3,5,6], target = 0
//Output: 0
// Example 5: 
// Input: nums = [1], target = 0
//Output: 0
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums contains distinct values sorted in ascending order. 
// -104 <= target <= 104 
// 
// Related Topics Array Binary Search 
// 👍 4194 👎 309


package leetcode.editor.en;

import java.util.Arrays;

public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int tmp = Arrays.binarySearch(nums, target);
            if (tmp < 0) {
                return -tmp - 1;
            } else {
                return tmp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}