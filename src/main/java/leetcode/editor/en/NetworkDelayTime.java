//You are given a network of n nodes, labeled from 1 to n. You are also given ti
//mes, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui 
//is the source node, vi is the target node, and wi is the time it takes for a sig
//nal to travel from source to target. 
//
// We will send a signal from a given node k. Return the time it takes for all t
//he n nodes to receive the signal. If it is impossible for all the n nodes to rec
//eive the signal, return -1. 
//
// 
// Example 1: 
//
// 
//Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: times = [[1,2,1]], n = 2, k = 1
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: times = [[1,2,1]], n = 2, k = 2
//Output: -1
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= n <= 100 
// 1 <= times.length <= 6000 
// times[i].length == 3 
// 1 <= ui, vi <= n 
// ui != vi 
// 0 <= wi <= 100 
// All the pairs (ui, vi) are unique. (i.e., no multiple edges.) 
// 
// Related Topics Depth-First Search Breadth-First Search Graph Heap (Priority Q
//ueue) Shortest Path 
// 👍 3475 👎 264


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public static void main(String[] args) {
        Solution solution = new NetworkDelayTime().new Solution();
        System.out.println(solution.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            List<List<Integer>>[] graph = new List[n + 1];
            for (int i = 0; i < n + 1; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < times.length; i++) {
                int[] e = times[i];
                List<Integer> tmp = new ArrayList<>();
                tmp.add(e[1]);
                tmp.add(e[2]);
                graph[e[0]].add(tmp);
            }

            PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distFromStart));
            pq.add(new State(k, 0));

            int[] dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            while (!pq.isEmpty()) {
                State s = pq.poll();
                if (s.distFromStart >= dist[s.id]) {
                    continue;
                }

                dist[s.id] = s.distFromStart;

                for (int i = 0; i < graph[s.id].size(); i++) {
                    List<Integer> e = graph[s.id].get(i);
                    int to = e.get(0);
                    int val = e.get(1);
                    if (s.distFromStart + val < dist[to]) {
                        pq.add(new State(to, s.distFromStart + val));
                    }
                }
            }

            int res = -1;
            for (int i = 1; i < dist.length; i++) {
                if (dist[i] == Integer.MAX_VALUE) return -1;
                res = Math.max(res, dist[i]);
            }
            return res;
        }

        class State {
            // 图节点的 id
            int id;
            // 从 start 节点到当前节点的距离
            int distFromStart;

            State(int id, int distFromStart) {
                this.id = id;
                this.distFromStart = distFromStart;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}