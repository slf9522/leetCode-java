//Given two strings text1 and text2, return the length of their longest common s
//ubsequence. If there is no common subsequence, return 0. 
//
// A subsequence of a string is a new string generated from the original string 
//with some characters (can be none) deleted without changing the relative order o
//f the remaining characters. 
//
// 
// For example, "ace" is a subsequence of "abcde". 
// 
//
// A common subsequence of two strings is a subsequence that is common to both s
//trings. 
//
// 
// Example 1: 
//
// 
//Input: text1 = "abcde", text2 = "ace" 
//Output: 3  
//Explanation: The longest common subsequence is "ace" and its length is 3.
// 
//
// Example 2: 
//
// 
//Input: text1 = "abc", text2 = "abc"
//Output: 3
//Explanation: The longest common subsequence is "abc" and its length is 3.
// 
//
// Example 3: 
//
// 
//Input: text1 = "abc", text2 = "def"
//Output: 0
//Explanation: There is no such common subsequence, so the result is 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= text1.length, text2.length <= 1000 
// text1 and text2 consist of only lowercase English characters. 
// 
// Related Topics String Dynamic Programming 
// 👍 5058 👎 58


package leetcode.editor.en;

/**
 * 最长公共子序列
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestCommonSubsequence().new Solution();
        System.out.println(solution.longestCommonSubsequence("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence2(String text1, String text2) {
            int[][] dp = new int[text1.length()][text2.length()];
            return dp(text1, 0, text2, 0, dp);
        }

        // 自底向上
        public int dp(String text1, int i, String text2, int j, int[][] dp) {
            if (i == text1.length()) return 0;
            if (j == text2.length()) return 0;

            if (dp[i][j] != 0) return dp[i][j];

            char ci = text1.charAt(i);
            char cj = text2.charAt(j);

            if (ci == cj) {
                dp[i][j] = dp(text1, i + 1, text2, j + 1, dp) + 1;
            } else {
                dp[i][j] = Math.max(
                        dp(text1, i + 1, text2, j, dp),
                        dp(text1, i, text2, j + 1, dp)
                );
            }
            return dp[i][j];
        }

        // 自顶向下
        public int longestCommonSubsequence(String text1, String text2) {
            int res = 0;
            int[][] dp = new int[text1.length() + 1][text2.length() + 1];
            for (int i = 1; i < text1.length() + 1; i++) {
                for (int j = 1; j < text2.length() + 1; j++) {
                    char ci = text1.charAt(i - 1);
                    char cj = text2.charAt(j - 1);
                    if (ci == cj) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(
                                dp[i - 1][j],
                                dp[i][j - 1]
                        );
                    }
                    res = Math.max(res, dp[i][j]);
                }
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}