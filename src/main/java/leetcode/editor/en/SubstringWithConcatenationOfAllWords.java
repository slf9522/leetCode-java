//You are given a string s and an array of strings words of the same length. Ret
//urn all starting indices of substring(s) in s that is a concatenation of each wo
//rd in words exactly once, in any order, and without any intervening characters. 
//
//
// You can return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: s = "barfoothefoobarman", words = ["foo","bar"]
//Output: [0,9]
//Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" re
//spectively.
//The output order does not matter, returning [9,0] is fine too.
// 
//
// Example 2: 
//
// 
//Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//Output: []
// 
//
// Example 3: 
//
// 
//Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//Output: [6,9,12]
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 104 
// s consists of lower-case English letters. 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// words[i] consists of lower-case English letters. 
// ø
// Related Topics Hash Table String Sliding Window 
// 👍 1424 👎 1580


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        Solution solution = new SubstringWithConcatenationOfAllWords().new Solution();
        System.out.println(solution.findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
//    解法参考：https://leetcode.com/problems/substring-with-concatenation-of-all-words/discuss/13664/Simple-Java-Solution
//   -with-Two-Pointers-and-Map
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<>();
            // 直接特判不存在解法
            if (s == null || words == null || s.length() < words.length * words[0].length()) {
                return res;
            }
            int wordL = words[0].length();

            // 输入的word可能重复，构建map计数，同时用来后续遍历的时候
            Map<String, Integer> wordMap = new HashMap<>();
            for (String word : words) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }

            // 遍历，只要匹配到了map里的，map.get(word)-1
            // 外循环为起始点，寻找匹配的开头
            for (int i = 0; i <= s.length() - wordL * words.length; i++) {
//                内循环每次移动一个word宽度
                Map<String, Integer> copy = new HashMap<>(wordMap);
                int j = i;
                for (; j < i + wordL * words.length && j < s.length(); j += wordL) {
                    String sub = s.substring(j, j + wordL);
                    if (copy.containsKey(sub)) {
                        int cnt = copy.get(sub);
                        if (cnt == 1) {
                            copy.remove(sub);
                        } else {
                            copy.put(sub, cnt - 1);
                        }
                        if (copy.isEmpty()) {
                            res.add(i);
                        }
                    } else {
                        break;
                    }
                }
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}