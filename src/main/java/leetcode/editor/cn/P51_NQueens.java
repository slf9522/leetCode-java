//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics 数组 回溯 👍 2052 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * N 皇后
 *
 * @author JX
 * @date 2024-03-28 17:09:51
 */
public class P51_NQueens {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P51_NQueens().new Solution();
        System.out.println(solution.solveNQueens(4));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> res = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            char[][] map = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = '.';
                }
            }
            backTrace(n, 0, map);
            return res;
        }

        private void backTrace(int n, int row, char[][] map) {
            if (row == n) {
                List<String> result = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    StringBuffer sb = new StringBuffer();
                    for (int j = 0; j < n; j++) {
                        sb.append(map[i][j]);
                    }
                    result.add(sb.toString());
                }
                res.add(result);
                return;
            }

            for (int i = 0; i < n; i++) {
                if (!valid(map, row, i)) continue;
                map[row][i] = 'Q';
                backTrace(n, row + 1, map);
                map[row][i] = '.';
            }
        }

        private boolean valid(char[][] map, int row, int col) {
            int e1 = col + row;
            int e2 = col - row;
            int n = map.length;
            for (int i = 0; i < n; i++) {
                if (map[i][col] == 'Q') return false;
                if (map[row][i] == 'Q') return false;
                if (e1 >= 0 && e1 < n) {
                    if (map[i][e1] == 'Q') {
                        return false;
                    }
                }
                e1--;
                if (e2 >= 0 && e2 < n) {
                    if (map[i][e2] == 'Q') {
                        return false;
                    }
                }
                e2++;
            }


            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}