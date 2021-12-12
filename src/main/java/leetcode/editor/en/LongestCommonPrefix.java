//Write a function to find the longest common prefix string amongst an array of 
//strings. 
//
// If there is no common prefix, return an empty string "". 
//
// 
// Example 1: 
//
// 
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
// 
//
// Example 2: 
//
// 
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
// 
//
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] consists of only lower-case English letters. 
// 
// Related Topics String 
// 👍 4967 👎 2395


package leetcode.editor.en;

public class LongestCommonPrefix {
    public static void main(String[] args) {

        Solution solution = new LongestCommonPrefix().new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            String shortest = strs[0];
            for (int i = 1; i < strs.length; i++) {
                shortest = getSub(shortest, strs[i]);
                if (shortest == "") {
                    break;
                }
            }
            return shortest;
        }

        private String getSub(String s1, String s2) {
            int i = 0;
            for (; i < s1.length(); i++) {
                if (i < s2.length() && s1.substring(0, i + 1).equals(s2.substring(0, i + 1))) {

                } else {
                    break;
                }
            }
            return s1.substring(0, i);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}