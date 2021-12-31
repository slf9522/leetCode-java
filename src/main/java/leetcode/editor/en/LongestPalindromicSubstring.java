//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
//b bb
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// Example 3: 
//
// 
//Input: s = "a"
//Output: "a"
// 
//
// Example 4: 
//
// 
//Input: s = "ac"
//Output: "a"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters (lower-case and/or upper-case), 
//
// 
// Related Topics String Dynamic Programming 
// 👍 12207 👎 750


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {

        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("aaaa"));
    }

    // 1 2 3
    // "babab"
    // index - center: 0 - 0; 1- 1; 2 - 1; 3 - 2; 4 - 2

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome2(String s) {
            int l = s.length();
            int[][] dp = new int[l][l];
            for (int i = 0; i < l; i++) {
                dp[i][i] = 1;
            }


            // (l-2, l-2), (l-2, l-1)
            //             (l-1,l-1)
            // j-i = 1
            int i = l - 2;


            int maxdp = 1;
            int start = 0;
            for (; i >= 0; i--) {
                int j = i + 1;
                for (; j < l; j++) {
                    if (j - i == 1) {
                        dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 0;
                    } else if (j - i == 2) {
                        dp[i][j] = s.charAt(i) == s.charAt(j) ? 3 : 0;
                    } else if (dp[i + 1][j - 1] != 0 && s.charAt(i) == s.charAt(j) && i + 1 < j - 1) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = 0;
                    }
                    if (maxdp < dp[i][j]) {
                        start = i;
                        maxdp = dp[i][j];
                    }
                }
            }
            return s.substring(start, start + maxdp);
        }

        public String longestPalindrome(String s) {
            String res = s.substring(0, 1);

            boolean[] dp = new boolean[s.length()];
            dp[0] = true;

            for (int i = 1; i < s.length(); i++) {
                dp[i] = true;
                for (int j = 0; j < i; j++) {
                    if (s.charAt(j) == s.charAt(i)) {
                        if (j + 1 == i || j + 2 == i) {
                            res = res.length() < s.substring(j, i + 1).length() ? s.substring(j, i + 1) : res;
                            dp[j] = true;
                        } else if (dp[j + 1]) {
                            res = res.length() < s.substring(j, i + 1).length() ? s.substring(j, i + 1) : res;
                            dp[j] = true;
                        } else {
                            dp[j] = false;
                        }
                    } else {
                        dp[j] = false;
                    }
                }
            }
            return res;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}