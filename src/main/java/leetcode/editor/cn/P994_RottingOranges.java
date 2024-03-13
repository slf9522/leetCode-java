//在给定的 m x n 网格
// grid 中，每个单元格可以有以下三个值之一： 
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。 
//
// 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
// 
//
// 示例 3： 
//
// 
//输入：grid = [[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
//
// Related Topics 广度优先搜索 数组 矩阵 👍 821 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 腐烂的橘子
 *
 * @author JX
 * @date 2024-03-13 15:55:16
 */
public class P994_RottingOranges {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P994_RottingOranges().new Solution();
        System.out.println(solution.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 1}, {0, 1, 2}}));
//        System.out.println(solution.orangesRotting(new int[][]{{2, 1, 1}, {0,1,1}, {1,0,1}}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int orangesRotting(int[][] grid) {

            int m = grid.length;
            int n = grid[0].length;

            int res = 0;
            Deque<int[]> dq = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        dq.addLast(new int[]{i, j});
                    }
                }
            }

            res += bfs(grid, dq);

            boolean flag = true;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    flag = flag & grid[i][j] == 0;
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }
            if (flag) return 0;
            return res;
        }

        private int bfs(int[][] grid, Deque<int[]> dq) {
            int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

            int cnt = 0;
            while (dq.size() != 0) {
                int size = dq.size();
                for (int m = 0; m < size; m++) {
                    int[] ele = dq.pollFirst();
                    grid[ele[0]][ele[1]] = 3;

                    for (int k = 0; k < 4; k++) {
                        int x = ele[0] + direction[k][0];
                        int y = ele[1] + direction[k][1];
                        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) continue;
                        if (grid[x][y] == 2 || grid[x][y] == 3) {
                            grid[x][y] = 3;
                            continue;
                        }
                        if (grid[x][y] == 1) {
                            grid[x][y] = 2;
                            dq.addLast(new int[]{x, y});
                        }
                    }
                }
                cnt++;
            }
            return cnt - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}