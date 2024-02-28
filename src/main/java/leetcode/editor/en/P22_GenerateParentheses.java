//Given n pairs of parentheses, write a function to generate all combinations 
//of well-formed parentheses. 
//
// 
// Example 1: 
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// 
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
//
// Related Topics String Dynamic Programming Backtracking 👍 20476 👎 875


package leetcode.editor.en;

import java.util.LinkedList;
import java.util.List;

/**
 * Generate Parentheses
 *
 * @author JX
 * @date 2024-02-19 19:44:55
 */
public class P22_GenerateParentheses {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P22_GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        LinkedList<String> res = new LinkedList<>();

        public List<String> generateParenthesis(int n) {

            String path = "";
            backTrace(n, n, 2 * n, path);
            return res;
        }

        public void backTrace(int l, int r, int n, String path) {
            if (n == 0) {
                res.add(path);
                return;
            }
            if (l == r) {
                backTrace(l - 1, r, n - 1, path + "(");
            } else {
                if (l > 0) {
                    backTrace(l - 1, r, n - 1, path + "(");
                }
                if (r > 0) {
                    backTrace(l, r - 1, n - 1, path + ")");
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
