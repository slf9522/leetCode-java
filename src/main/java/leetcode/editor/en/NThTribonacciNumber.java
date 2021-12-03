//The Tribonacci sequence Tn is defined as follows: 
//
// T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0. 
//
// Given n, return the value of Tn. 
//
// 
// Example 1: 
//
// 
//Input: n = 4
//Output: 4
//Explanation:
//T_3 = 0 + 1 + 1 = 2
//T_4 = 1 + 1 + 2 = 4
// 
//
// Example 2: 
//
// 
//Input: n = 25
//Output: 1389537
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 37 
// The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 -
// 1. 
// Related Topics Math Dynamic Programming Memoization 
// 👍 1226 👎 78


package leetcode.editor.en;

public class NThTribonacciNumber {
    public static void main(String[] args) {
        Solution solution = new NThTribonacciNumber().new Solution();
        System.out.println(solution.tribonacci(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int tribonacci(int n) {
            int[] dp = new int[]{0, 1, 1, 0};
            if (n <= 2) return dp[n];
            int i = 3;
            for (; i <= n; i++) {
                dp[i % 4] = dp[(i - 1) % 4] + dp[(i - 2) % 4] + dp[(i - 3) % 4];
            }
            return dp[i % 4];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}