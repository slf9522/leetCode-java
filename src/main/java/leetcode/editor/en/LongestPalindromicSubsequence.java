//Given a string s, find the longest palindromic subsequence's length in s. 
//
// A subsequence is a sequence that can be derived from another sequence by dele
//ting some or no elements without changing the order of the remaining elements. 
//
// 
// Example 1: 
//
// 
//Input: s = "bbbab"
//Output: 4
//Explanation: One possible longest palindromic subsequence is "bbbb".
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: 2
//Explanation: One possible longest palindromic subsequence is "bb".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists only of lowercase English letters. 
// 
// Related Topics String Dynamic Programming 
// 👍 4433 👎 237


package leetcode.editor.en;

import org.omg.CORBA.ARG_IN;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubsequence().new Solution();
        System.out.println(solution.longestPalindromeSubseq("bbbab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindromeSubseq(String s) {
            int res = 1;
            int[][] dp = new int[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = 1;
            }
            for (int j = 1; j < s.length(); j++) {
                for (int i = j - 1; i >= 0; i--) {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (i + 1 <= j) dp[i][j] = Math.max(dp[i][j], 2);

                        if (i + 2 <= j) dp[i][j] = Math.max(dp[i][j], 3);

                        if (i + 3 <= j) dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 2);

                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                    res = Math.max(res, dp[i][j]);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}