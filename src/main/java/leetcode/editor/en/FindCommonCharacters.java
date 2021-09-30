//Given a string array words, return an array of all characters that show up in 
//all strings within the words (including duplicates). You may return the answer i
//n any order. 
//
// 
// Example 1: 
// Input: words = ["bella","label","roller"]
//Output: ["e","l","l"]
// Example 2: 
// Input: words = ["cool","lock","cook"]
//Output: ["c","o"]
// 
// 
// Constraints: 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 100 
// words[i] consists of lowercase English letters. 
// 
// Related Topics Array Hash Table String 
// 👍 1811 👎 164


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

// 解法参考：https://books.halfrost.com/leetcode/ChapterFour/1000~1099/1002.Find-Common-Characters/
public class FindCommonCharacters {
    public static void main(String[] args) {
        Solution solution = new FindCommonCharacters().new Solution();
//        System.out.println(String.valueOf((char) ('a' + 1)));
        System.out.println(solution.commonChars(new String[]{"bella", "label", "roller"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> commonChars(String[] words) {
            List<String> res = new ArrayList<>();
            int[] preIndex = new int[26];

            for (int i = 0; i < words[0].length(); i++) {
                preIndex[words[0].charAt(i) - 'a']++;
            }

            for (int i = 1; i < words.length; i++) {
                int[] nextIndex = new int[26];
                for (int j = 0; j < words[i].length(); j++) {
                    nextIndex[words[i].charAt(j) - 'a'] += 1;
                }
                for (int j = 0; j < preIndex.length; j++) {
                    preIndex[j] = Math.min(preIndex[j], nextIndex[j]);
                }
            }
            for (int i = 0; i < preIndex.length; i++) {
                while (preIndex[i]-- > 0) {
                    res.add(String.valueOf((char) (i + 'a')));
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}