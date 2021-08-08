//Given two sorted arrays nums1 and nums2 of size m and n respectively, return t
//he median of the two sorted arrays. 
//
// The overall run time complexity should be O(log (m+n)). 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
// 
//
// Example 3: 
//
// 
//Input: nums1 = [0,0], nums2 = [0,0]
//Output: 0.00000
// 
//
// Example 4: 
//
// 
//Input: nums1 = [], nums2 = [1]
//Output: 1.00000
// 
//
// Example 5: 
//
// 
//Input: nums1 = [2], nums2 = []
//Output: 2.00000
// 
//
// 
// Constraints: 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics Array Binary Search Divide and Conquer 
// 👍 11370 👎 1611


package leetcode.editor.en;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{2}, new int[]{}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int i = 0;
            int j = 0;
            int mid;
            boolean even = (nums1.length + nums2.length) % 2 == 0;
            int index = 0;
            int pre = 0;
            double res = 0;
            // 4 , stop at 2, cal index 1 and 2
            // 3, stop at 1, cal index 1
            mid = (nums1.length + nums2.length) / 2;
            while (index <= mid && i < nums1.length || j < nums2.length) {

                int ii = i < nums1.length ? nums1[i] : Integer.MAX_VALUE;
                int jj = j < nums2.length ? nums2[j] : Integer.MAX_VALUE;

                if (even && index == mid) {
                    res = (pre + Math.min(ii, jj)) / 2.0;
                    break;
                } else if(index == mid) {
                    res = Math.min(ii, jj);
                    break;
                }

                if (ii < jj) {
                    i++;
                    pre = ii;
                } else {
                    j++;
                    pre = jj;
                }
                index++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}