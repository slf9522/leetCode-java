//Given an array of strings strs, group the anagrams together. You can return th
//e answer in any order. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a differe
//nt word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Example 2: 
// Input: strs = [""]
//Output: [[""]]
// Example 3: 
// Input: strs = ["a"]
//Output: [["a"]]
// 
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 104 
// 0 <= strs[i].length <= 100 
// strs[i] consists of lower-case English letters. 
// 
// Related Topics Hash Table String Sorting 
// 👍 6543 👎 252


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * https://leetcode.com/problems/group-anagrams/discuss/19176/Share-my-short-JAVA-solution
 * 如何用字符串生成唯一key，
 * 1. split以后sort
 * 2. 顺序填入字符数组中（因为字符不会重复）
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        System.out.println(solution.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                String[] subStr = str.split("");
                Arrays.sort(subStr);
                String key = String.join("", subStr);
                if (map.containsKey(key)) {
                    map.get(key).add(str);
                } else {
                    map.put(key, new ArrayList<>());
                    map.get(key).add(str);
                }
            }
            return new ArrayList<>(map.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}