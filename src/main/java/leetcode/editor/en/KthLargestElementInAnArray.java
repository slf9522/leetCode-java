//Given an integer array nums and an integer k, return the kth largest element i
//n the array. 
//
// Note that it is the kth largest element in the sorted order, not the kth dist
//inct element. 
//
// 
// Example 1: 
// Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5
// Example 2: 
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4
// 
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// 
// Related Topics Array Divide and Conquer Sorting Heap (Priority Queue) Quickse
//lect 
// 👍 7725 👎 432


package leetcode.editor.en;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return sortP(nums, 0, nums.length - 1, nums.length - k);
        }

        /**
         * 1、注意end的含义
         * 2、Math.random的使用，[start, end)区间
         * p, k的未知关系
         */
        public int sortP(int[] nums, int start, int end, int k) {
            int index = (int) (Math.random() * (end - start + 1));
            swap(nums, start + index, end);
            int p = start;
            for (int i = start; i < end; i++) {
                if (nums[i] <= nums[end]) {
                    swap(nums, i, p++);
                }
            }
            swap(nums, p, end);
            if (p == k) {
                return nums[p];
//                p k
            } else if (k > p) {
                return sortP(nums, p + 1, end, k);
            } else {
                return sortP(nums, start, p - 1, k);
            }
        }

        private void swap(int[] nums, int index, int end) {
            int tmp = nums[index];
            nums[index] = nums[end];
            nums[end] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}