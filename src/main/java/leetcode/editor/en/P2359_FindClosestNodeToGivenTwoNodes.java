//You are given a directed graph of n nodes numbered from 0 to n - 1, where 
//each node has at most one outgoing edge. 
//
// The graph is represented with a given 0-indexed array edges of size n, 
//indicating that there is a directed edge from node i to node edges[i]. If there is no 
//outgoing edge from i, then edges[i] == -1. 
//
// You are also given two integers node1 and node2. 
//
// Return the index of the node that can be reached from both node1 and node2, 
//such that the maximum between the distance from node1 to that node, and from 
//node2 to that node is minimized. If there are multiple answers, return the node 
//with the smallest index, and if no possible answer exists, return -1. 
//
// Note that edges may contain cycles. 
//
// 
// Example 1: 
// 
// 
//Input: edges = [2,2,3,-1], node1 = 0, node2 = 1
//Output: 2
//Explanation: The distance from node 0 to node 2 is 1, and the distance from 
//node 1 to node 2 is 1.
//The maximum of those two distances is 1. It can be proven that we cannot get 
//a node with a smaller maximum distance than 1, so we return node 2.
// 
//
// Example 2: 
// 
// 
//Input: edges = [1,2,-1], node1 = 0, node2 = 2
//Output: 2
//Explanation: The distance from node 0 to node 2 is 2, and the distance from 
//node 2 to itself is 0.
//The maximum of those two distances is 2. It can be proven that we cannot get 
//a node with a smaller maximum distance than 2, so we return node 2.
// 
//
// 
// Constraints: 
//
// 
// n == edges.length 
// 2 <= n <= 10⁵ 
// -1 <= edges[i] < n 
// edges[i] != i 
// 0 <= node1, node2 < n 
// 
//
// Related Topics Depth-First Search Graph 👍 1639 👎 390


package leetcode.editor.en;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Find Closest Node to Given Two Nodes
 *
 * @author JX
 * @date 2024-02-19 19:06:33
 */
public class P2359_FindClosestNodeToGivenTwoNodes {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P2359_FindClosestNodeToGivenTwoNodes().new Solution();
        System.out.println(solution.closestMeetingNode(new int[]{4, 3, 0, 5, 3, -1}, 4, 0));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int closestMeetingNode(int[] edges, int node1, int node2) {
            int[] d1 = calcDis(edges, node1), d2 = calcDis(edges, node2);
            int ans = -1, n = edges.length;
            for (int i = 0, minDis = n; i < n; ++i) {
                int d = Math.max(d1[i], d2[i]);
                if (d < minDis) {
                    minDis = d;
                    ans = i;
                }
            }
            return ans;
        }

        public int[] calcDis(int[] edges, int x) {
            int n = edges.length;
            int[] dis = new int[n];
            Arrays.fill(dis, n);
            for (int d = 0; x >= 0 && dis[x] == n; x = edges[x])
                dis[x] = d++;
            return dis;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
