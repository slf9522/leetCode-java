//给定一个整数 n，即有向图中的节点数，其中节点标记为 0 到 n - 1。图中的每条边为红色或者蓝色，并且可能存在自环或平行边。 
//
// 给定两个数组 redEdges 和 blueEdges，其中： 
//
// 
// redEdges[i] = [ai, bi] 表示图中存在一条从节点 ai 到节点 bi 的红色有向边， 
// blueEdges[j] = [uj, vj] 表示图中存在一条从节点 uj 到节点 vj 的蓝色有向边。 
// 
//
// 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，
//那么 answer[x] = -1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
//输出：[0,1,-1]
// 
//
// 示例 2： 
//
// 
//输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
//输出：[0,1,-1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 0 <= redEdges.length, blueEdges.length <= 400 
// redEdges[i].length == blueEdges[j].length == 2 
// 0 <= ai, bi, uj, vj < n 
// 
//
// Related Topics 广度优先搜索 图 👍 298 👎 0


package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 颜色交替的最短路径
 *
 * @author JX
 * @date 2024-03-24 15:01:20
 */
public class P1129_ShortestPathWithAlternatingColors {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1129_ShortestPathWithAlternatingColors().new Solution();
        // {{0,1},{1,2},{2,3},{3,4}} {{1,2},{2,3},{3,1}}
        System.out.println(solution.shortestAlternatingPaths(5, new int[][] {{0,1},{1,2},{2,3},{3,4}}, new int[][]{{1,2},{2,3},{3,1}}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
            List<Integer>[][] g = new List[2][n];
            for (List<Integer>[] f : g) {
                Arrays.setAll(f, k -> new ArrayList<>());
            }
            for (int[] e : redEdges) {
                g[0][e[0]].add(e[1]);
            }
            for (int[] e : blueEdges) {
                g[1][e[0]].add(e[1]);
            }
            Deque<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{0, 0});
            q.offer(new int[]{0, 1});
            boolean[][] vis = new boolean[n][2];
            int[] ans = new int[n];
            Arrays.fill(ans, -1);
            int d = 0;
            while (!q.isEmpty()) {
                for (int k = q.size(); k > 0; --k) {
                    int[] p = q.poll();
                    int i = p[0], c = p[1];
                    if (ans[i] == -1) {
                        ans[i] = d;
                    }
                    vis[i][c] = true;
                    c ^= 1;
                    for (int j : g[c][i]) {
                        if (!vis[j][c]) {
                            q.offer(new int[]{j, c});
                        }
                    }
                }
                ++d;
            }
            return ans;
        }

        public int[] shortestAlternatingPaths2(int n, int[][] redEdges, int[][] blueEdges) {
            LinkedList<Integer> l1 = new LinkedList<>();
            LinkedList<Integer> l2 = new LinkedList<>();


            Map<Integer, List<Integer>> m1 = new HashMap<>();
            Map<Integer, List<Integer>> m2 = new HashMap<>();
            for (int[] e : redEdges) {
                m1.putIfAbsent(e[0], new ArrayList<>());
                m1.get(e[0]).add(e[1]);
            }
            for (int[] e : blueEdges) {
                m2.putIfAbsent(e[0], new ArrayList<>());
                m2.get(e[0]).add(e[1]);
            }

            l1.add(0);
            l2.add(0);
            int[] res = new int[n];
            Arrays.fill(res, 101);
            res[0] = 0;

            boolean[] v1 = new boolean[n];
            boolean[] v2 = new boolean[n];
            v1[0] = true;
            getMin(l1, res, n, m1, m2, v1, v2);
            v1[0] =false; v2[0] = true;
            getMin(l2, res, n, m2, m1, v2, v2);
            for (int i = 0; i < n; i++) {
                res[i] = res[i] == 101 ? -1 : res[i];
            }
            return res;
        }

        void getMin(LinkedList<Integer> l1, int[] res, int n, Map<Integer, List<Integer>> m1, Map<Integer, List<Integer>> m2
                , boolean[] v1, boolean[] v2) {

            boolean flag = true;
            int cnt = 0;
            while (!l1.isEmpty()) {
                int s = l1.size();
                HashSet<Integer> set = new HashSet<>();
                for (int i = 0; i < s; i++) {
                    Integer v = l1.pollFirst();
                    if (flag) {
                        v1[v] = true;
                    } else {
                        v2[v] = true;
                    }


                    res[v] = Math.min(res[v], cnt);
                    if (flag) {
                        if (m1.containsKey(v)) {
                            set.addAll(m1.get(v));
                        }

                    } else {
                        if (m2.containsKey(v)) {
                            set.addAll(m2.get(v));
                        }

                    }
                }
                l1.addAll(set.stream().filter(e -> !v1[e] || !v2[e]).collect(Collectors.toSet()));
                cnt++;
                flag = !flag;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}