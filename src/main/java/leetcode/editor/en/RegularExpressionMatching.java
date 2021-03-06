//Given an input string s and a pattern p, implement regular expression matching
// with support for '.' and '*' where: 
//
// 
// '.' Matches any single character. 
// '*' Matches zero or more of the preceding element. 
// 
//
// The matching should cover the entire input string (not partial). 
//
// 
// Example 1: 
//
// 
//Input: s = "aa", p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
// 
//
// Example 2: 
//
// 
//Input: s = "aa", p = "a*"
//Output: true
//Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, 
//by repeating 'a' once, it becomes "aa".
// 
//
// Example 3: 
//
// 
//Input: s = "ab", p = ".*"
//Output: true
//Explanation: ".*" means "zero or more (*) of any character (.)".
// 
//
// Example 4: 
//
// 
//Input: s = "aab", p = "c*a*b"
//Output: true
//Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, i
//t matches "aab".
// 
//
// Example 5: 
//
// 
//Input: s = "mississippi", p = "mis*is*p*."
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 20 
// 1 <= p.length <= 30 
// s contains only lowercase English letters. 
// p contains only lowercase English letters, '.', and '*'. 
// It is guaranteed for each appearance of the character '*', there will be a pr
//evious valid character to match. 
// 
// Related Topics String Dynamic Programming Recursion 
// 👍 6247 👎 892


package leetcode.editor.en;

// 要删除不匹配任何字母的 a* pattern
public class RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching().new Solution();
        System.out.println(solution.isMatch("aab", "c*a*b"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            // corner case
            if (s == null || p == null) return false;

            int m = s.length();
            int n = p.length();

            // M[i][j] represents if the 1st i characters in s can match the 1st j characters in p
            boolean[][] M = new boolean[m + 1][n + 1];

            // initialization:
            // 1. M[0][0] = true, since empty string matches empty pattern
            M[0][0] = true;

            // 2. M[i][0] = false(which is default value of the boolean array) since empty pattern cannot match
            //non-empty string
            // 3. M[0][j]: what pattern matches empty string ""? It should be #*#*#*#*..., or (#*)* if allow me to
            //represent regex using regex :P,
            // and for this case we need to check manually:
            // as we can see, the length of pattern should be even && the character at the even position should be *,
            // thus for odd length, M[0][j] = false which is default. So we can just skip the odd position, i.e. j
            //starts from 2, the interval of j is also 2.
            // and notice that the length of repeat sub-pattern #* is only 2, we can just make use of M[0][j - 2]
            //rather than scanning j length each time
            // for checking if it matches #*#*#*#*.
            for (int j = 2; j < n + 1; j += 2) {
                if (p.charAt(j - 1) == '*' && M[0][j - 2]) {
                    M[0][j] = true;
                }
            }

            // Induction rule is very similar to edit distance, where we also consider from the end. And it is based
            //on what character in the pattern we meet.
            // 1. if p.charAt(j) == s.charAt(i), M[i][j] = M[i - 1][j - 1]
            //    ######a(i)
            //    ####a(j)
            // 2. if p.charAt(j) == '.', M[i][j] = M[i - 1][j - 1]
            // 	  #######a(i)
            //    ####.(j)
            // 3. if p.charAt(j) == '*':
            //    1. if p.charAt(j - 1) != '.' && p.charAt(j - 1) != s.charAt(i), then b* is counted as empty.
            //   M[i][j] = M[i][j - 2]
            //       #####a(i)
            //       ####b*(j)
            //    2.if p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i):
            //       ######a(i)
            //       ####.*(j)
            //
            // 	  	 #####a(i)
            //    	 ###a*(j)
            //      2.1 if p.charAt(j - 1) is counted as empty, then M[i][j] = M[i][j - 2]
            //      2.2 if counted as one, then M[i][j] = M[i - 1][j - 2]
            //      2.3 if counted as multiple, then M[i][j] = M[i - 1][j]

            // recap:
            // M[i][j] = M[i - 1][j - 1]
            // M[i][j] = M[i - 1][j - 1]
            // M[i][j] = M[i][j - 2]
            // M[i][j] = M[i][j - 2]
            // M[i][j] = M[i - 1][j - 2]
            // M[i][j] = M[i - 1][j]
            // Observation: from above, we can see to get M[i][j], we need to know previous elements in M, i.e. we
            //need to compute them first.
            // which determines i goes from 1 to m - 1, j goes from 1 to n + 1

            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    char curS = s.charAt(i - 1);
                    char curP = p.charAt(j - 1);
                    if (curS == curP || curP == '.') {
                        M[i][j] = M[i - 1][j - 1];
                    } else if (curP == '*') {
                        char preCurP = p.charAt(j - 2);
                        if (preCurP != '.' && preCurP != curS) {
                            M[i][j] = M[i][j - 2];
                        } else {
                            M[i][j] = (M[i][j - 2] || M[i - 1][j - 2] || M[i - 1][j]);
                        }
                    }
                }
            }

            return M[m][n];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

