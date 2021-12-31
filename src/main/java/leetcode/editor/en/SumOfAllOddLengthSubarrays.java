//Given an array of positive integers arr, calculate the sum of all possible odd
//-length subarrays. 
//
// A subarray is a contiguous subsequence of the array. 
//
// Return the sum of all odd-length subarrays of arr. 
//
// 
// Example 1: 
//
// 
//Input: arr = [1,4,2,5,3]
//Output: 58
//Explanation: The odd-length subarrays of arr and their sums are:
//[1] = 1
//[4] = 4
//[2] = 2
//[5] = 5
//[3] = 3
//[1,4,2] = 7
//[4,2,5] = 11
//[2,5,3] = 10
//[1,4,2,5,3] = 15
//If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58 
//
//
// Example 2: 
//
// 
//Input: arr = [1,2]
//Output: 3
//Explanation: There are only 2 subarrays of odd length, [1] and [2]. Their sum 
//is 3. 
//
// Example 3: 
//
// 
//Input: arr = [10,11,12]
//Output: 66
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 100 
// 1 <= arr[i] <= 1000 
// 
// Related Topics Array Math Prefix Sum 
// 👍 1483 👎 135


package leetcode.editor.en;

public class SumOfAllOddLengthSubarrays {
    public static void main(String[] args) {
        Solution solution = new SumOfAllOddLengthSubarrays().new Solution();
        System.out.println(solution.sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumOddLengthSubarrays(int[] arr) {
            if (arr.length == 1) return arr[0];

            int[] cnt = new int[arr.length];
            int[] sum = new int[arr.length];
            cnt[0] = 1;
            cnt[1] = 1;
            sum[0] = arr[0];
            sum[1] = arr[1];

            int res = arr[0] + arr[1];
            for (int i = 2; i < arr.length; i++) {
                int tmp = cnt[i - 2] * (arr[i] + arr[i - 1]) + arr[i] + sum[i - 2];
                res += tmp;

                cnt[i] = cnt[i - 2] + 1;
                sum[i] = tmp;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}