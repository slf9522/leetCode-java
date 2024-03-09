//给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
//输出: 4
//解释: 下雨后，雨水将会被上图蓝色的方块中。总的接雨水量为1+2+1=4。
// 
//
// 示例 2: 
//
// 
//
// 
//输入: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
//输出: 10
// 
//
// 
//
// 提示: 
//
// 
// m == heightMap.length 
// n == heightMap[i].length 
// 1 <= m, n <= 200 
// 0 <= heightMap[i][j] <= 2 * 10⁴ 
// 
//
// 
//
// Related Topics 广度优先搜索 数组 矩阵 堆（优先队列） 👍 720 👎 0


package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 接雨水 II
 *
 * @author JX
 * @date 2024-03-09 12:54:02
 */
public class P407_TrappingRainWaterIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P407_TrappingRainWaterIi().new Solution();
        System.out.println(solution.trapRainWater(new int[][]{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trapRainWater(int[][] heightMap) {
            int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {0, 1}};
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
            int m = heightMap.length;
            int n = heightMap[0].length;
            boolean[][] visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                pq.offer(new int[]{i, 0, heightMap[i][0]});
                pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
                visited[i][0] = true;
                visited[i][n - 1] = true;
            }

            for (int i = 0; i < n; i++) {
                pq.offer(new int[]{0, i, heightMap[0][i]});
                pq.offer(new int[]{m - 1, i, heightMap[m - 1][i]});
                visited[0][i] = true;
                visited[m - 1][i] = true;
            }

            int res = 0;
            while (!pq.isEmpty()) {
                int[] p = pq.poll();
                for (int i = 0; i < 4; i++) {
                    int x = p[0] + direction[i][0];
                    int y = p[1] + direction[i][1];

                    if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
                    if (p[2] > heightMap[x][y]) {
                        res += p[2]-heightMap[x][y];
                    }
                    visited[x][y] = true;
                    heightMap[x][y] = Math.max(p[2], heightMap[x][y]);
                    pq.offer(new int[]{x, y, heightMap[x][y]});
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}