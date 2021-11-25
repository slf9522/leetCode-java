//Given a string word, return the sum of the number of vowels ('a', 'e', 'i', 'o
//', and 'u') in every substring of word. 
//
// A substring is a contiguous (non-empty) sequence of characters within a strin
//g. 
//
// Note: Due to the large constraints, the answer may not fit in a signed 32-bit
// integer. Please be careful during the calculations. 
//
// 
// Example 1: 
//
// 
//Input: word = "aba"
//Output: 6
//Explanation: 
//All possible substrings are: "a", "ab", "aba", "b", "ba", and "a".
//- "b" has 0 vowels in it
//- "a", "ab", "ba", and "a" have 1 vowel each
//- "aba" has 2 vowels in it
//Hence, the total sum of vowels = 0 + 1 + 1 + 1 + 1 + 2 = 6. 
// 
//
// Example 2: 
//
// 
//Input: word = "abc"
//Output: 3
//Explanation: 
//All possible substrings are: "a", "ab", "abc", "b", "bc", and "c".
//- "a", "ab", and "abc" have 1 vowel each
//- "b", "bc", and "c" have 0 vowels each
//Hence, the total sum of vowels = 1 + 1 + 1 + 0 + 0 + 0 = 3. 
//
// Example 3: 
//
// 
//Input: word = "ltcd"
//Output: 0
//Explanation: There are no vowels in any substring of "ltcd". 
//
// Example 4: 
//
// 
//Input: word = "noosabasboosa"
//Output: 237
//Explanation: There are a total of 237 vowels in all the substrings.
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length <= 105 
// word consists of lowercase English letters. 
// 
// Related Topics Math String Dynamic Programming Combinatorics 
// 👍 195 👎 11


package leetcode.editor.en;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class VowelsOfAllSubstrings {
    public static void main(String[] args) {
        Solution solution = new VowelsOfAllSubstrings().new Solution();
        System.out.println(solution.countVowels("noosabasboosa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long countVowels(String word) {
            Set<Character> set = new HashSet<>();
            set.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u'));

            long res = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (set.contains(c)) {
                    // 0~(i-1) i-1-0+1+1 (i+1)~(n-1) (n-1-i-1+1+1)
                    res = res + (long) (i + 1) * (word.length() - i);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}