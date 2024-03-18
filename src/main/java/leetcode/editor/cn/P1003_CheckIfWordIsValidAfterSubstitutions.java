//给你一个字符串 s ，请你判断它是否 有效 。
//
// 字符串 s 有效 需要满足：假设开始有一个空字符串 t = "" ，你可以执行 任意次 下述操作将 t 转换为 s ： 
//
// 
// 将字符串 "abc" 插入到 t 中的任意位置。形式上，t 变为 tleft + "abc" + tright，其中 t == tleft + 
//tright 。注意，tleft 和 tright 可能为 空 。 
// 
//
// 如果字符串 s 有效，则返回 true；否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aabcbc"
//输出：true
//解释：
//"" -> "abc" -> "aabcbc"
//因此，"aabcbc" 有效。 
//
// 示例 2： 
//
// 
//输入：s = "abcabcababcc"
//输出：true
//解释：
//"" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
//因此，"abcabcababcc" 有效。 
//
// 示例 3： 
//
// 
//输入：s = "abccba"
//输出：false
//解释：执行操作无法得到 "abccba" 。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁴ 
// s 由字母 'a'、'b' 和 'c' 组成 
// 
//
// Related Topics 栈 字符串 👍 140 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 检查替换后的词是否有效
 *
 * @author JX
 * @date 2024-03-13 16:24:10
 */
public class P1003_CheckIfWordIsValidAfterSubstitutions {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1003_CheckIfWordIsValidAfterSubstitutions().new Solution();
        System.out.println(solution.isValid("aaabc"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            LinkedList<Character> stack = new LinkedList<>();

            boolean flag = true;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (stack.size() == 0) {
                    if (c != 'a') {
                        flag = false;
                        break;
                    }
                }

                if (c == 'a') {
                    stack.addLast(c);
                } else if (c == 'b') {
                    if (stack.peekLast() != 'a') {
                        flag = false;
                        break;
                    }
                    stack.addLast(c);
                } else if (c == 'c') {
                    stack.addLast(c);
                    flag = checkAndPop(stack);
                    if (!flag) return false;
                }
            }
            return flag && stack.size()==0;
        }

        private boolean checkAndPop(LinkedList<Character> stack) {
            if (stack.isEmpty()) return true;
            if (!stack.isEmpty() && stack.peekLast() != 'c') return true;
            if (!stack.isEmpty() && stack.peekLast() == 'c' && stack.size() < 3) return false;
            boolean flag = (stack.pollLast() == 'c') && (stack.pollLast() == 'b') && (stack.pollLast() == 'a');
            if (!flag) return false;
            return checkAndPop(stack);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}