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
import java.util.List;

/**
 * Word Break
 * @author JX
 * @date 2024-02-26 10:57:09
 */
public class P139_WordBreak{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P139_WordBreak().new Solution();
		  solution.wordBreak("leetcode", Arrays.asList("leet", "code"));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
		if (s.isEmpty()) return true;
		boolean flag = false;

		for (int i = 0; i <= s.length(); i++) {
			String sub = s.substring(0,i);
			if (wordDict.contains(sub)){
				flag = flag | wordBreak(s.substring(i), wordDict);
				if(flag) return true;
			}
		}
		return flag;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
