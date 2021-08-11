//Implement next permutation, which rearranges numbers into the lexicographicall
//y next greater permutation of numbers. 
//
// If such an arrangement is not possible, it must rearrange it as the lowest po
//ssible order (i.e., sorted in ascending order). 
//
// The replacement must be in place and use only constant extra memory. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: [1,3,2]
// Example 2: 
// Input: nums = [3,2,1]
//Output: [1,2,3]
// Example 3: 
// Input: nums = [1,1,5]
//Output: [1,5,1]
// Example 4: 
// Input: nums = [1]
//Output: [1]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics Array Two Pointers 
// 👍 6627 👎 2184


package leetcode.editor.en;

import java.util.Arrays;

//参考解法 https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0031.Next-Permutation/
//https://leetcode.com/problems/next-permutation/discuss/13867/C%2B%2B-from-Wikipedia
public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        solution.nextPermutation(new int[]{1, 2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int left = nums.length - 1;
            int right = left;
            while (left > 0) {
                if (nums[left - 1] < nums[left]) {
                    break;
                }
                left--;
            }

            if (left == 0) {
                Arrays.sort(nums);
                return;
            }

            left--;
            while (right != left) {
                if (nums[right] > nums[left]) {
                    break;
                }
                right--;
            }

            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            Arrays.sort(nums, left + 1, nums.length);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}