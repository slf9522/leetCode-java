//Given an array of integers arr and two integers k and threshold. 
//
// Return the number of sub-arrays of size k and average greater than or equal t
//o threshold. 
//
// 
// Example 1: 
//
// 
//Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
//Output: 3
//Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 r
//espectively. All other sub-arrays of size 3 have averages less than 4 (the thres
//hold).
// 
//
// Example 2: 
//
// 
//Input: arr = [1,1,1,1,1], k = 1, threshold = 0
//Output: 5
// 
//
// Example 3: 
//
// 
//Input: arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
//Output: 6
//Explanation: The first 6 sub-arrays of size 3 have averages greater than 5. No
//te that averages are not integers.
// 
//
// Example 4: 
//
// 
//Input: arr = [7,7,7,7,7,7,7], k = 7, threshold = 7
//Output: 1
// 
//
// Example 5: 
//
// 
//Input: arr = [4,4,4,4], k = 4, threshold = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 10^5 
// 1 <= arr[i] <= 10^4 
// 1 <= k <= arr.length 
// 0 <= threshold <= 10^4 
// 
// Related Topics Array Sliding Window 
// 👍 358 👎 49


package leetcode.editor.en;

// 平均数可以反过来用乘法，减少计算步骤
public class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {
    public static void main(String[] args) {
        Solution solution = new NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold().new Solution();
        System.out.println(solution.numOfSubarrays(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numOfSubarrays(int[] arr, int k, int threshold) {
            int i = 0, j = 0;
            int sum = 0;
            int cnt = 0;
            while (j < k && j < arr.length) {
                sum += arr[j++];
            }
            double avg = sum / k / 1.0;
            if (avg >= threshold) cnt++;
            while (j < arr.length) {
                avg = (avg * k - arr[i++] + arr[j]) / k / 1.0;
                if (avg >= threshold) cnt++;
                j++;
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}