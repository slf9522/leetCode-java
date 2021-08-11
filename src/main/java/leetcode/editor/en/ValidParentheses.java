//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: s = "(]"
//Output: false
// 
//
// Example 4: 
//
// 
//Input: s = "([)]"
//Output: false
// 
//
// Example 5: 
//
// 
//Input: s = "{[]}"
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 104 
// s consists of parentheses only '()[]{}'. 
// 
// Related Topics String Stack 
// 👍 8471 👎 342


package leetcode.editor.en;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ValidParentheses {
    public static void main(String[] args) {

        Solution solution = new ValidParentheses().new Solution();
        System.out.println(solution.isValid("([)]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Deque<Character> stack = new LinkedList<>();
            List<Character> left = Arrays.asList('{', '(', '[');
            List<Character> right = Arrays.asList('}', ')', ']');

            int i = 0;
            while (i < s.length()) {
                Character ci = s.charAt(i);
                if (left.contains(ci)) {
                    stack.addLast(ci);
                } else {
                    if (stack.size() > 0 && left.contains(stack.peekLast())
                            && left.indexOf(stack.peekLast()) == right.indexOf(ci)) {
                        stack.removeLast();
                    } else {
                        return false;
                    }
                }
                i++;
            }
            return stack.size() == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}