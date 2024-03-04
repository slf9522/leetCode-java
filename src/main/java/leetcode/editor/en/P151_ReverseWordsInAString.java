//Given an input string s, reverse the order of the words. 
//
// A word is defined as a sequence of non-space characters. The words in s will 
//be separated by at least one space. 
//
// Return a string of the words in reverse order concatenated by a single space.
// 
//
// Note that s may contain leading or trailing spaces or multiple spaces 
//between two words. The returned string should only have a single space separating the 
//words. Do not include any extra spaces. 
//
// 
// Example 1: 
//
// 
//Input: s = "the sky is blue"
//Output: "blue is sky the"
// 
//
// Example 2: 
//
// 
//Input: s = "  hello world  "
//Output: "world hello"
//Explanation: Your reversed string should not contain leading or trailing 
//spaces.
// 
//
// Example 3: 
//
// 
//Input: s = "a good   example"
//Output: "example good a"
//Explanation: You need to reduce multiple spaces between two words to a single 
//space in the reversed string.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s contains English letters (upper-case and lower-case), digits, and spaces ' 
//'. 
// There is at least one word in s. 
// 
//
// 
// Follow-up: If the string data type is mutable in your language, can you 
//solve it in-place with O(1) extra space? 
//
// Related Topics Two Pointers String 👍 8027 👎 5063


package leetcode.editor.en;

/**
 * Reverse Words in a String
 *
 * @author JX
 * @date 2024-03-04 15:31:32
 */
public class P151_ReverseWordsInAString {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P151_ReverseWordsInAString().new Solution();
        System.out.println(solution.reverseWords("a good example"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            StringBuffer sb = new StringBuffer();
            int l = s.length();

            for (int i = l-1; i >= 0; ) {
                if (s.charAt(i)==' ') {
                    i--;
                    continue;
                }
                int j = i-1;
                while(j>=0 && s.charAt(j)!=' ') j--;
                if(j<0){
                    sb.append(s.substring(0,i+1));
                    sb.append(' ');
                } else {
                    sb.append(s.substring(j+1,i+1));
                    sb.append(' ');
                }
                i = j;
            }
            return sb.toString().trim();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
