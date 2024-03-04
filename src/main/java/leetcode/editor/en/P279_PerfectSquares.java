//Given an integer n, return the least number of perfect square numbers that 
//sum to n. 
//
// A perfect square is an integer that is the square of an integer; in other 
//words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 
//are perfect squares while 3 and 11 are not. 
//
// 
// Example 1: 
//
// 
//Input: n = 12
//Output: 3
//Explanation: 12 = 4 + 4 + 4.
// 
//
// Example 2: 
//
// 
//Input: n = 13
//Output: 2
//Explanation: 13 = 4 + 9.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁴ 
// 
//
// Related Topics Math Dynamic Programming Breadth-First Search 👍 11030 👎 459


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Perfect Squares
 *
 * @author JX
 * @date 2024-02-29 12:56:40
 */
public class P279_PerfectSquares {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P279_PerfectSquares().new Solution();
        System.out.println(solution.numSquares(13));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numSquares(int n) {
            List<Integer> square = new ArrayList<>();
            int[] dp = new int[n + 1];
            Arrays.fill(dp, n);
            for (int i = 1; i <= n; i++) {
                int tmp = i * i;
                if (tmp == n) return 1;

                if (tmp < n) {
                    square.add(tmp);
                    dp[tmp] = 1;
                }
            }

            for (int i = 2; i < n + 1; i++) {
                for (int j = 0; j < square.size(); j++) {
                    int s = square.get(j);
                    int cnt = 1;
                    while (i - s * cnt >= 1) {
                        dp[i] = Math.min(dp[i], cnt + dp[i - s * cnt]);
                        cnt++;
                    }
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
