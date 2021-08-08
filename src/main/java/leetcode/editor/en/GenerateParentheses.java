//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses. 
//
// 
// Example 1: 
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2: 
// Input: n = 1
//Output: ["()"]
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
// Related Topics String Dynamic Programming Backtracking 
// 👍 9189 👎 362


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {

        Solution solution = new GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            genPair(n - 1, n, "(", res);
            return res;
        }

        private void genPair(int left, int right, String s, List<String> res) {
            if (left == 0 && right == 0) {
                res.add(s);
                return;
            }
            if (left < right) {
                genPair(left, right - 1, s + ")", res);
            }
            if (left != 0) {
                genPair(left - 1, right, s + "(", res);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}