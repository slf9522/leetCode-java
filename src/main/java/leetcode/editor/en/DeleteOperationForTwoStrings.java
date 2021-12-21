//Given two strings word1 and word2, return the minimum number of steps required
// to make word1 and word2 the same. 
//
// In one step, you can delete exactly one character in either string. 
//
// 
// Example 1: 
//
// 
//Input: word1 = "sea", word2 = "eat"
//Output: 2
//Explanation: You need one step to make "sea" to "ea" and another step to make 
//"eat" to "ea".
// 
//
// Example 2: 
//
// 
//Input: word1 = "leetcode", word2 = "etco"
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= word1.length, word2.length <= 500 
// word1 and word2 consist of only lowercase English letters. 
// 
// Related Topics String Dynamic Programming 
// 👍 2353 👎 39


package leetcode.editor.en;

public class DeleteOperationForTwoStrings {
    public static void main(String[] args) {
        Solution solution = new DeleteOperationForTwoStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            int common = longestCommonSubsequence(word1, word2);
            return word1.length() + word2.length() - 2 * common;
        }

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