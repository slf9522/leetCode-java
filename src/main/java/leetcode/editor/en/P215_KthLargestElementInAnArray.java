//Given an integer array nums and an integer k, return the kᵗʰ largest element 
//in the array. 
//
// Note that it is the kᵗʰ largest element in the sorted order, not the kᵗʰ 
//distinct element. 
//
// Can you solve it without sorting? 
//
// 
// Example 1: 
// Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5
// 
// Example 2: 
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4
// 
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics Array Divide and Conquer Sorting Heap (Priority Queue) 
//Quickselect 👍 16648 👎 838


package leetcode.editor.en;

import static org.apache.commons.lang3.ArrayUtils.swap;

/**
 * Kth Largest Element in an Array
 *
 * @author JX
 * @date 2024-02-28 10:06:56
 */
public class P215_KthLargestElementInAnArray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P215_KthLargestElementInAnArray().new Solution();
        System.out.println(solution.findKthLargest(new int[]{2, 1}, 2));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int l = nums.length;
            int lo = 0, hi = l - 1;
            int index = 0;
            k = l - k;

            index = partition(nums, lo, hi);
            while (index != k) {
                index = partition(nums, lo, hi);
                if (index < k) {
                    lo = index + 1;
                } else if (index > k) {
                    hi = index - 1;
                }
            }
            return nums[index];
        }

        int partition(int[] num, int lo, int hi) {
            int v = num[lo];
            int l = lo + 1; // [lo, l) <= pivot
            int r = hi; // (r, hi] > pivot
            while (l <= r) {

                while (l < hi && num[l] <= v) {
                    l++;
                }
                // 判断条件不能重复 num[r] >= v 就不行了，l和r可能超过边界，比如全部都小于v的情况
                while (r > lo && num[r] > v) {
                    r--;
                }

                if (l >= r) {
                    break;
                }

                swap(num, l, r);
                // [lo, l] <=pivot [r, hi] >= pivot
            }
            // l>r,所以选r交换
            swap(num, lo, r);

            return r;

        }

        void swap(int[] num, int lo, int hi) {
            int tmp = num[lo];
            num[lo] = num[hi];
            num[hi] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
