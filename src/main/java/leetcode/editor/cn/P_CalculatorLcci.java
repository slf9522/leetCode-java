//给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。 
//
// 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。 
//
// 示例 1: 
//
// 输入: "3+2*2"
//输出: 7
// 
//
// 示例 2: 
//
// 输入: " 3/2 "
//输出: 1 
//
// 示例 3: 
//
// 输入: " 3+5 / 2 "
//输出: 5
// 
//
// 说明： 
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
//
// Related Topics 栈 数学 字符串 👍 105 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 计算器
 *
 * @author JX
 * @date 2024-03-30 20:48:07
 */
public class P_CalculatorLcci {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P_CalculatorLcci().new Solution();
        System.out.println(solution.calculate("3+2*2"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            LinkedList<Object> deque = new LinkedList<>();
            int l = s.length();
            for (int i = 0; i < l; ) {
                char c = s.charAt(i);
                if (c == ' ') {
                    i++;
                } else if (c == '+' || c == '-') {
                    deque.addLast(c);
                    i++;
                } else if (c == '*' || c == '/') {
                    int v = (int) deque.pollLast();
                    int v2 = 0;
                    i = i + 1;
                    for (; i < s.length(); i++) {
                        if (s.charAt(i) == ' ') continue;
                        if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9){
                            v2 = v2 * 10 + s.charAt(i) - '0';
                        } else {
                            break;
                        }
                    }

                    if (c == '*') {
                        v2 = v * v2;
                    } else {
                        v2 = v / v2;
                    }
                    deque.addLast(v2);
                } else {
                    int v = 0;
                    for (; i < s.length() && (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9); i++) {
                        v = v * 10 + s.charAt(i) - '0';
                    }
                    deque.addLast(v);
                }
            }
            int res = 0;
            for (int i = 0; i < deque.size(); ) {
                Object o = deque.get(i);
                if (o instanceof Integer) {
                    res += (int) o;
                    i++;
                } else {
                    if ((char) o == '+') {
                        res += (int) deque.get(i + 1);
                    } else {
                        res -= (int) deque.get(i + 1);
                    }
                    i += 2;
                }
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}