//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 4381 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 有效的括号
 *
 * @author JX
 * @date 2024-03-13 12:25:13
 */
public class P20_ValidParentheses {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P20_ValidParentheses().new Solution();
        System.out.println(solution.isValid("{()}"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if (s.length() == 1) return false;

            Set<Character> left = new HashSet<>(Arrays.asList('(', '[', '{'));
            Set<Character> right = new HashSet<>(Arrays.asList(')', ']', '}'));

            Stack<Character> stack = new Stack<>();

            int i = 0;
            while (i < s.length()) {
                char c = s.charAt(i++);
                if (stack.isEmpty() && right.contains(c)) return false;
                if (left.contains(c)) {
                    stack.push(c);
                    continue;
                }

                if (!stack.isEmpty()) {
                    char pre = stack.peek();
                    if ((pre == '(' && c == ')') || (pre == '[' && c == ']') || (pre == '{' && c == '}')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
            return stack.size() == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
