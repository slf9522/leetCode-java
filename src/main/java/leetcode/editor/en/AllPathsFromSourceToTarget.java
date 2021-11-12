//Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find 
//all possible paths from node 0 to node n - 1 and return them in any order. 
//
// The graph is given as follows: graph[i] is a list of all nodes you can visit 
//from node i (i.e., there is a directed edge from node i to node graph[i][j]). 
//
// 
// Example 1: 
//
// 
//Input: graph = [[1,2],[3],[3],[]]
//Output: [[0,1,3],[0,2,3]]
//Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
// 
//
// Example 2: 
//
// 
//Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
//Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
// 
//
// Example 3: 
//
// 
//Input: graph = [[1],[]]
//Output: [[0,1]]
// 
//
// Example 4: 
//
// 
//Input: graph = [[1,2,3],[2],[3],[]]
//Output: [[0,1,2,3],[0,2,3],[0,3]]
// 
//
// Example 5: 
//
// 
//Input: graph = [[1,3],[2],[3],[]]
//Output: [[0,1,2,3],[0,3]]
// 
//
// 
// Constraints: 
//
// 
// n == graph.length 
// 2 <= n <= 15 
// 0 <= graph[i][j] < n 
// graph[i][j] != i (i.e., there will be no self-loops). 
// All the elements of graph[i] are unique. 
// The input graph is guaranteed to be a DAG. 
// 
// Related Topics Backtracking Depth-First Search Breadth-First Search Graph 
// 👍 2876 👎 103


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        Solution solution = new AllPathsFromSourceToTarget().new Solution();
        System.out.println(solution.allPathsSourceTarget(new int[][]{{1, 2, 3}, {2}, {3}, {}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            Map<Integer, List<List<Integer>>> buffer = new HashMap<>();
            allPathsSourceTarget(graph, 0, buffer);
            return buffer.get(0);
        }

        /**
         * @param graph
         * @param index  这次要开始遍历的节点
         * @param buffer 已经访问过的节点信息
         * @return
         */
        public List<List<Integer>> allPathsSourceTarget(int[][] graph, int index,
                                                        Map<Integer, List<List<Integer>>> buffer) {
            List<List<Integer>> tmpRes = new ArrayList<>();
            if (index == graph.length - 1) {
                tmpRes.add(Arrays.asList(index));
                return tmpRes;
            }

            for (int i = 0; i < graph[index].length; i++) {
                int next = graph[index][i];
                List<List<Integer>> bufferL = buffer.get(next);
                if (bufferL == null) bufferL = allPathsSourceTarget(graph, next, buffer);
//                    已经访问过，但是不可达终点
                if (bufferL.size() == 0) continue;
                List<List<Integer>> newPath = bufferL.stream().map(l -> {
                    List<Integer> newL = new ArrayList<>(l);
                    newL.add(0, index);
                    return newL;
                }).collect(Collectors.toList());
                if (newPath.size() > 0) tmpRes.addAll(newPath);
            }
            buffer.put(index, tmpRes);
            return tmpRes;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}