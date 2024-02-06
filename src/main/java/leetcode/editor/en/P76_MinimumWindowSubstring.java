//Given two strings s and t of lengths m and n respectively, return the minimum 
//window substring of s such that every character in t (including duplicates) is 
//included in the window. If there is no such substring, return the empty string 
//"". 
//
// The testcases will be generated such that the answer is unique. 
//
// 
// Example 1: 
//
// 
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' 
//from string t.
// 
//
// Example 2: 
//
// 
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.
// 
//
// Example 3: 
//
// 
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.
//Since the largest window of s only has one 'a', return empty string.
// 
//
// 
// Constraints: 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s and t consist of uppercase and lowercase English letters. 
// 
//
// 
// Follow up: Could you find an algorithm that runs in O(m + n) time? 
//
// Related Topics Hash Table String Sliding Window 👍 17090 👎 696


package leetcode.editor.en;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Minimum Window Substring
 *
 * @author DY
 * @date 2024-02-04 19:31:03
 */
public class P76_MinimumWindowSubstring {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P76_MinimumWindowSubstring().new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            int[] tcnt = new int[52];
            char[] ta = t.toCharArray();
            for (int i = 0; i < ta.length; i++) {
                tcnt[ta[i] - 'A']++;
            }

            // 左闭右开区间，right下一个要放进去的数
            int left = 0;
            int right = 0;

            int[] wcnt = new int[52];
            String subString = s;
            while (right <= s.length() -1) {

                wcnt[s.charAt(right) - 'A']++;
                right++;
                if (checkEqual(tcnt, wcnt)) {
                    while (left < right && checkEqual(tcnt, wcnt)) {
                        subString = s.substring(left, right).length() < subString.length() ? s.substring(left, right) : subString;
                        wcnt[s.charAt(left) - 'A']--;
                        left++;
                    }
                }


            }
            return subString.equals(s) ? "" : subString;
        }

        boolean checkEqual(int[] tcnt, int[] wcnt) {
            for (int i = 0; i < 52; i++) {
                if (tcnt[i] > wcnt[i]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
