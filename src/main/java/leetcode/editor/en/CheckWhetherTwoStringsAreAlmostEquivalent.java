//Two strings word1 and word2 are considered almost equivalent if the difference
//s between the frequencies of each letter from 'a' to 'z' between word1 and word2
// is at most 3. 
//
// Given two strings word1 and word2, each of length n, return true if word1 and
// word2 are almost equivalent, or false otherwise. 
//
// The frequency of a letter x is the number of times it occurs in the string. 
//
// 
// Example 1: 
//
// 
//Input: word1 = "aaaa", word2 = "bccb"
//Output: false
//Explanation: There are 4 'a's in "aaaa" but 0 'a's in "bccb".
//The difference is 4, which is more than the allowed 3.
// 
//
// Example 2: 
//
// 
//Input: word1 = "abcdeef", word2 = "abaaacc"
//Output: true
//Explanation: The differences between the frequencies of each letter in word1 a
//nd word2 are at most 3:
//- 'a' appears 1 time in word1 and 4 times in word2. The difference is 3.
//- 'b' appears 1 time in word1 and 1 time in word2. The difference is 0.
//- 'c' appears 1 time in word1 and 2 times in word2. The difference is 1.
//- 'd' appears 1 time in word1 and 0 times in word2. The difference is 1.
//- 'e' appears 2 times in word1 and 0 times in word2. The difference is 2.
//- 'f' appears 1 time in word1 and 0 times in word2. The difference is 1.
// 
//
// Example 3: 
//
// 
//Input: word1 = "cccddabba", word2 = "babababab"
//Output: true
//Explanation: The differences between the frequencies of each letter in word1 a
//nd word2 are at most 3:
//- 'a' appears 2 times in word1 and 4 times in word2. The difference is 2.
//- 'b' appears 2 times in word1 and 5 times in word2. The difference is 3.
//- 'c' appears 3 times in word1 and 0 times in word2. The difference is 3.
//- 'd' appears 2 times in word1 and 0 times in word2. The difference is 2.
// 
//
// 
// Constraints: 
//
// 
// n == word1.length == word2.length 
// 1 <= n <= 100 
// word1 and word2 consist only of lowercase English letters. 
// 
// Related Topics Hash Table String Counting 
// 👍 73 👎 2


package leetcode.editor.en;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CheckWhetherTwoStringsAreAlmostEquivalent {
    public static void main(String[] args) {
        Solution solution = new CheckWhetherTwoStringsAreAlmostEquivalent().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * hash解法，暴力遍历
         * 自己构造hash更节省！！
         *
         * @param word1
         * @param word2
         * @return
         */
        public boolean checkAlmostEquivalent2(String word1, String word2) {
            // 统计字符串中字符出现的次数
            Map<String, Long> w1 =
                    Arrays.stream(word1.split("")).collect(Collectors.groupingBy(Function.identity(),
                            Collectors.counting()));

            Map<String, Long> w2 =
                    Arrays.stream(word2.split("")).collect(Collectors.groupingBy(Function.identity(),
                            Collectors.counting()));
            // 不能直接在w1.keySet中添加，unmodified
            Set<String> allSet = new HashSet<>(w1.keySet());
            allSet.addAll(w2.keySet());
            for (String key : allSet) {
                if (Math.abs(w2.getOrDefault(key, 0L) - w1.getOrDefault(key, 0L)) > 3) {
                    return false;
                }
            }
            return true;
        }

        public boolean checkAlmostEquivalent(String word1, String word2) {
            // 统计字符串中字符出现的次数
            int[] alpha = new int[26];
            for (char c : word1.toCharArray()) alpha[c - 'a']++;
            for (char c : word2.toCharArray()) alpha[c - 'a']--;
            for (int cnt : alpha) {
                if (Math.abs(cnt) > 3) return false;
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}