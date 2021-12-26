//You are given two arrays of integers nums1 and nums2, possibly of different le
//ngths. The values in the arrays are between 1 and 6, inclusive. 
//
// In one operation, you can change any integer's value in any of the arrays to 
//any value between 1 and 6, inclusive. 
//
// Return the minimum number of operations required to make the sum of values in
// nums1 equal to the sum of values in nums2. Return -1 if it is not possible to m
//ake the sum of the two arrays equal. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
//Output: 3
//Explanation: You can make the sums of nums1 and nums2 equal with 3 operations.
// All indices are 0-indexed.
//- Change nums2[0] to 6. nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2].
//- Change nums1[5] to 1. nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2].
//- Change nums1[2] to 2. nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2].
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,1,1,1,1,1,1], nums2 = [6]
//Output: -1
//Explanation: There is no way to decrease the sum of nums1 or to increase the s
//um of nums2 to make them equal.
// 
//
// Example 3: 
//
// 
//Input: nums1 = [6,6], nums2 = [1]
//Output: 3
//Explanation: You can make the sums of nums1 and nums2 equal with 3 operations.
// All indices are 0-indexed. 
//- Change nums1[0] to 2. nums1 = [2,6], nums2 = [1].
//- Change nums1[1] to 2. nums1 = [2,2], nums2 = [1].
//- Change nums2[0] to 4. nums1 = [2,2], nums2 = [4].
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums1.length, nums2.length <= 105 
// 1 <= nums1[i], nums2[i] <= 6 
// 
// Related Topics Array Hash Table Greedy Counting 
// 👍 412 👎 11


package leetcode.editor.en;

import java.util.Arrays;

/**
 * https://juejin.cn/post/6992227789713702948 微软面试题
 * 两个数组，改变其中一个数，使两个数组的和相等，求最小变动的数目。
 * <p>
 * 举个例子，数组nums1:[1,2,3,4,5,6]，nums2:[1,1,2,2,2,2]
 * <p>
 * 要使得它们和相等，需要变动两次，nums1：[1,2,3,4,5,1]，nums2:[7,1,2,2,2,2]
 * <p>
 * 不是动态规划！因为可以子问题可以选出最合适的！
 * 贪心
 */
public class EqualSumArraysWithMinimumNumberOfOperations {
    public static void main(String[] args) {
        Solution solution = new EqualSumArraysWithMinimumNumberOfOperations().new Solution();
        System.out.println(solution.minOperations(new int[]{5, 6, 4, 3, 1, 2}, new int[]{6, 3, 3, 1, 4, 5, 3, 4, 1, 3
                , 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums1, int[] nums2) {
            int sum1 = Arrays.stream(nums1).sum();
            int sum2 = Arrays.stream(nums2).sum();

            int res = 0;
            int diff = sum1 - sum2;
            if (diff != 0) {
                int[] small = diff > 0 ? nums2 : nums1;
                int[] large = diff > 0 ? nums1 : nums2;
                // 可以加的值
                int[] smallD = Arrays.stream(small).map(e -> 6 - e).toArray();
                // 可以减的值
                int[] largeD = Arrays.stream(large).map(e -> e - 1).toArray();

                int[] all = new int[smallD.length + largeD.length];
                System.arraycopy(smallD, 0, all, 0, smallD.length);
                System.arraycopy(largeD, 0, all, smallD.length, largeD.length);
                Arrays.sort(all);
                int i = all.length - 1;
                diff = Math.abs(diff);
                while (diff > 0 && i >= 0) {
                    diff -= all[i--];
                    res++;
                }
            }

            if (diff > 0) return -1;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}