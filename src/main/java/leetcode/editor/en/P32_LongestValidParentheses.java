//Given a string containing just the characters '(' and ')', return the length 
//of the longest valid (well-formed) parentheses substring. 
//
// 
// Example 1: 
//
// 
//Input: s = "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()".
// 
//
// Example 2: 
//
// 
//Input: s = ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()".
// 
//
// Example 3: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] is '(', or ')'. 
// 
//
// Related Topics String Dynamic Programming Stack 👍 12106 👎 386


package leetcode.editor.en;

import java.util.*;

/**
 * Longest Valid Parentheses
 *
 * @author JX
 * @date 2024-02-21 21:37:45
 */
public class P32_LongestValidParentheses {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P32_LongestValidParentheses().new Solution();
        System.out.println(solution.longestValidParentheses(")()())"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses2(String s) {
            if(s.length() == 0 || s.length() == 1) return 0;

            int[] dp = new int[s.length()];
            dp[0] = 0;
            List<Character> chars = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                chars.add(s.charAt(i));
            }

            int max = 0;
            for (int i = 1; i < chars.size(); i++) {
                Stack<Character> stack = new Stack<>();
                stack.addAll(chars.subList(0, i+1));

                int l = 0;
                int r = 0;
                while (stack.size() != 0) {
                    Character c = stack.pop();
                    if (c == '(') {
                        l++;
                    } else {
                        r++;
                    }
                    if (l >= r) {
                        break;
                    }
                }

                if (l == r) {
                    dp[i] = l + r;
                    if (i - l - r>= 0) {
                        dp[i] += dp[i - l - r];
                    }
                    max = Math.max(max, dp[i]);
                }
            }
            return max;
        }

        public int longestValidParentheses(String s) {
            if (s == null || s.length() == 0) return 0;
            Deque<Integer> stack = new ArrayDeque<>();
            int dp [] = new int[s.length()];
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                //System.out.println(stack);
                if (s.charAt(i) == '(') stack.push(i);
                else {
                    if(!stack.isEmpty()){
                        int top = stack.pop();
                        dp[i] = i - top + 1;
                        if(top-1>=0)dp[i] += dp[top-1];
                        res = Math.max(res, dp[i]);
                    }
                }
            }
            return res;
        }
    }



//leetcode submit region end(Prohibit modification and deletion)

}
