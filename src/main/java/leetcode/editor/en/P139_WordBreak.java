//Given a string s and a dictionary of strings wordDict, return true if s can 
//be segmented into a space-separated sequence of one or more dictionary words. 
//
// Note that the same word in the dictionary may be reused multiple times in 
//the segmentation. 
//
// 
// Example 1: 
//
// 
//Input: s = "leetcode", wordDict = ["leet","code"]
//Output: true
//Explanation: Return true because "leetcode" can be segmented as "leet code".
// 
//
// Example 2: 
//
// 
//Input: s = "applepenapple", wordDict = ["apple","pen"]
//Output: true
//Explanation: Return true because "applepenapple" can be segmented as "apple 
//pen apple".
//Note that you are allowed to reuse a dictionary word.
// 
//
// Example 3: 
//
// 
//Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s and wordDict[i] consist of only lowercase English letters. 
// All the strings of wordDict are unique. 
// 
//
// Related Topics Array Hash Table String Dynamic Programming Trie Memoization ?
//? 16812 👎 747


package leetcode.editor.en;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Word Break
 *
 * @author JX
 * @date 2024-02-26 10:57:09
 */
public class P139_WordBreak {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P139_WordBreak().new Solution();
        System.out.println(solution.wordBreak("leetcode", Arrays.asList("leet", "code")));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean wordBreak(String s, List<String> wordDict) {
            int l = s.length();
            boolean[] dp = new boolean[l + 1];
            dp[0] = true;
            Set<String> set = new HashSet<>(wordDict);
            for (int i = 1; i < l + 1; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (set.contains(s.substring(j, i))) {
                        dp[i] = dp[i] | dp[j];
                    }
                }
            }
            return dp[l];
        }


        public boolean wordBreak2(String s, List<String> wordDict) {
            boolean res = false;

            for (int i = 0; i < wordDict.size(); i++) {
                String sub = wordDict.get(i);
                if (s.startsWith(sub)) {
                    if (s.equals(sub)) {
                        return true;
                    }
                    res = res | wordBreak2(s.substring(sub.length()), wordDict);
                }
                if (res) return true;
            }
            return false;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
