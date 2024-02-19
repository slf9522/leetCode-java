//Given two strings s1 and s2, return the lowest ASCII sum of deleted 
//characters to make two strings equal. 
//
// 
// Example 1: 
//
// 
//Input: s1 = "sea", s2 = "eat"
//Output: 231
//Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the 
//sum.
//Deleting "t" from "eat" adds 116 to the sum.
//At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum 
//possible to achieve this.
// 
//
// Example 2: 
//
// 
//Input: s1 = "delete", s2 = "leet"
//Output: 403
//Explanation: Deleting "dee" from "delete" to turn the string into "let",
//adds 100[d] + 101[e] + 101[e] to the sum.
//Deleting "e" from "leet" adds 101[e] to the sum.
//At the end, both strings are equal to "let", and the answer is 100+101+101+101
// = 403.
//If instead we turned both strings into "lee" or "eet", we would get answers 
//of 433 or 417, which are higher.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s1.length, s2.length <= 1000 
// s1 and s2 consist of lowercase English letters. 
// 
//
// Related Topics String Dynamic Programming 👍 3919 👎 105


package leetcode.editor.en;

/**
 * Minimum ASCII Delete Sum for Two Strings
 *
 * @author JX
 * @date 2024-02-14 14:10:29
 */
public class P712_MinimumAsciiDeleteSumForTwoStrings {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P712_MinimumAsciiDeleteSumForTwoStrings().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumDeleteSum(String s1, String s2) {
            int[][] dp = new int[s1.length()][s2.length()];
            return updateDP(dp, s1, 0, s2, 0);
        }

        private int updateDP(int[][] dp, String s1, int i, String s2, int j) {
            if (i >= s1.length()) {
                int res = 0;
                for (int k = j; k < s2.length(); k++) {
                    res += s2.charAt(k);
                }
                return res;
            }

            if (j >= s2.length()) {
                int res = 0;
                for (int k = i; k < s1.length(); k++) {
                    res += s1.charAt(k);
                }
                return res;
            }

            if(s1.charAt(i) == s2.charAt(j)) {
                dp[i][j] = updateDP(dp, s1, i+1, s2, j+1);
            } else{
                dp[i][j] = Math.min(
                        updateDP(dp, s1,i+1, s2, j) + s1.charAt(i),
                        updateDP(dp, s1,i, s2, j+1) + s2.charAt(j));
            }
            return dp[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
