//Given two strings s and t of lengths m and n respectively, return the minimum 
//window substring of s such that every character in t (including duplicates) is i
//ncluded in the window. If there is no such substring, return the empty string ""
//. 
//
// The testcases will be generated such that the answer is unique. 
//
// A substring is a contiguous sequence of characters within the string. 
//
// 
// Example 1: 
//
// 
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' fr
//om string t.
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
// 1 <= m, n <= 105 
// s and t consist of uppercase and lowercase English letters. 
// 
//
// 
//Follow up: Could you find an algorithm that runs in O(m + n) time? Related Top
//ics Hash Table String Sliding Window 
// 👍 7938 👎 487


package leetcode.editor.en;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        System.out.println(solution.minWindow("a", "a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //todo: https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can
    //-solve-most-'substring'-problems
    class Solution {
        public String minWindow(String s, String t) {
            int i = 0;
            int j = 0;
            List<String> sList = Arrays.stream(s.split("")).collect(Collectors.toList());
            int minWin = Integer.MAX_VALUE;
            String res = "";

            // 用来记录需要还需要匹配到的字母和个数
            Map<String, Integer> index =
                    Arrays.stream(t.split("")).collect(Collectors.toMap(Function.identity(), e -> 1, Math::addExact));
            // 用来记录还需要匹配的字母个数
            int tCount = t.length();

            while (j < sList.size()) {
                // 移动右侧
                while (j < sList.size() && tCount != 0) {
                    if (index.containsKey(sList.get(j))) {
                        // 只有t中的字母个数需要匹配
                        if (index.get(sList.get(j)) > 0) tCount--;
                        index.put(sList.get(j), index.getOrDefault(sList.get(j), 0) - 1);
                    }
                    j++;
                }

                //移动左侧
                while (tCount == 0) {
                    if (minWin > j - i) {
                        minWin = j - i;
                        res = s.substring(i, j);
                    }
                    if (index.containsKey(sList.get(i)) && index.get(sList.get(i)) == 0) {
                        tCount++;
                        index.put(sList.get(i), index.get(sList.get(i)) + 1);
                    } else if (index.containsKey(sList.get(i))) {
                        index.put(sList.get(i), index.get(sList.get(i)) + 1);
                    }
                    i++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}