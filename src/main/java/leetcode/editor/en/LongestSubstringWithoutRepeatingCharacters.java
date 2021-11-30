//Given a string s, find the length of the longest substring without repeating c
//haracters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// Example 4: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 104 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics Hash Table String Sliding Window 
// 👍 15959 👎 783


package leetcode.editor.en;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        solution.lengthOfLongestSubstring("abcabcbb");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring2(String s) {
            if (s.length() == 0) {
                return 0;
            }

            int i = 0;
            int j = i;
            int max = 1;

            Set<Character> uniq = new HashSet<>();
            uniq.add(s.charAt(i));

            // j是没有判断的
            while (i < s.length()) {
                j = Math.max(i + 1, j + 1);

                while (j < s.length()) {
                    if (uniq.contains(s.charAt(j))) {
                        break;
                    }
                    uniq.add(s.charAt(j));
                    j++;
                }

                max = Math.max(max, uniq.size());

                // 移动滑动窗口左侧，同时移除不在范围内的字符
                while (i < s.length() && j < s.length() && s.charAt(i) != s.charAt(j)) {
                    uniq.remove(s.charAt(i));
                    i++;
                }
                i++;
            }

            return uniq.size();
        }

        public int lengthOfLongestSubstring(String s) {
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                HashSet<String> set = new HashSet<>();
                int j = i;
                while (j < s.length()) {
                    if (!set.add(s.substring(j, j + 1))) {
                        res = Math.max(res, j - i + 1);
                        break;
                    }
                    j++;
                }
            }
            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}