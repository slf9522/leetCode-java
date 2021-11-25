//A substring is a contiguous (non-empty) sequence of characters within a string
//. 
//
// A vowel substring is a substring that only consists of vowels ('a', 'e', 'i',
// 'o', and 'u') and has all five vowels present in it. 
//
// Given a string word, return the number of vowel substrings in word. 
//
// 
// Example 1: 
//
// 
//Input: word = "aeiouu"
//Output: 2
//Explanation: The vowel substrings of word are as follows (underlined):
//- "aeiouu"
//- "aeiouu"
// 
//
// Example 2: 
//
// 
//Input: word = "unicornarihan"
//Output: 0
//Explanation: Not all 5 vowels are present, so there are no vowel substrings.
// 
//
// Example 3: 
//
// 
//Input: word = "cuaieuouac"
//Output: 7
//Explanation: The vowel substrings of word are as follows (underlined):
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac" 
//
// Example 4: 
//
// 
//Input: word = "bbaeixoubb"
//Output: 0
//Explanation: The only substrings that contain all five vowels also contain con
//sonants, so there are no vowel substrings.
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length <= 100 
// word consists of lowercase English letters only. 
// 
// Related Topics Hash Table String 
// 👍 179 👎 77


package leetcode.editor.en;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 找到包含 全部a e i o u字符的所有子字符串
 */
public class CountVowelSubstringsOfAString {
    public static void main(String[] args) {

        Solution solution = new CountVowelSubstringsOfAString().new Solution();
        System.out.println(solution.countVowelSubstrings("bbaeixoubb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 看似用滑动窗口，其实两层循环就可以，还有要看清题目
         *
         * @param word
         * @return
         */
        public int countVowelSubstrings(String word) {
            int res = 0;
            Set<Character> set = new HashSet<>();
            set.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u'));
            for (int i = 0; i < word.length(); i++) {
                if (!set.contains(word.charAt(i))) continue;
                // 这一步很重要，如果用滑动窗口+指针，就会很麻烦，不如重新建一个set
                HashSet<Character> alpha = new HashSet<>();
                for (int j = i; j < word.length() && set.contains(word.charAt(j)); j++) {
                    char cj = word.charAt(j);
                    if (set.contains(cj)) {
                        alpha.add(cj);
                        if (alpha.size() == 5) res++;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}