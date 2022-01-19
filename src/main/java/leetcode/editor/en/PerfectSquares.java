//Given an integer n, return the least number of perfect square numbers that sum
// to n. 
//
// A perfect square is an integer that is the square of an integer; in other wor
//ds, it is the product of some integer with itself. For example, 1, 4, 9, and 16 
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
// 1 <= n <= 104 
// 
// Related Topics Math Dynamic Programming Breadth-First Search 
// 👍 6056 👎 274


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 针对输入n，找到最小数目的平方数组合
 */
public class PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new PerfectSquares().new Solution();
        System.out.println(solution.numSquares(2752));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares2(int n) {
            int i = 1;
            List<Integer> squares = new ArrayList<>();

            while (Math.pow(i, 2) <= n) {
                squares.add((int) Math.pow(i, 2));
                i++;
            }

            return backTrack(squares, squares.size() - 1, n);
        }

        private int backTrack(List<Integer> squares, int start, int n) {
            int res = Integer.MAX_VALUE;
            for (int i = start; i >= 0; i--) {
                int num = squares.get(i);
                int cnt = n / num;

                if (cnt > res) break;
                if (cnt == 0) continue;
                if (n % num == 0) {
                    res = Math.min(res, cnt);
                    break;
                }

                while (cnt > 0) {
                    int tmp = backTrack(squares, start - 1, n - num * cnt);
                    if (tmp == Integer.MAX_VALUE) {
                        cnt--;
                        continue;
                    } else {
                        res = Math.min(res, cnt + tmp);
                        break;
                    }
                }
            }
            return res;
        }

        // 动态规划解法
        public int numSquares(int n) {
            if (n <= 0) return 0;
            int[] cntPerfectSquares = new int[n + 1];
            Arrays.fill(cntPerfectSquares, Integer.MAX_VALUE);
            cntPerfectSquares[0] = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j * j <= i; j++) {
                    cntPerfectSquares[i] = Math.min(cntPerfectSquares[i], cntPerfectSquares[i - j * j] + 1);
                }
            }
            return cntPerfectSquares[n];
        }
        // 静态动态规划
        public int numSquares3(int n) {
            if (n <= 0) return 0;
            int[] cntPerfectSquares = new int[n + 1];
            Arrays.fill(cntPerfectSquares, Integer.MAX_VALUE);
            cntPerfectSquares[0] = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j * j <= i; j++) {
                    cntPerfectSquares[i] = Math.min(cntPerfectSquares[i], cntPerfectSquares[i - j * j] + 1);
                }
            }
            return cntPerfectSquares[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}