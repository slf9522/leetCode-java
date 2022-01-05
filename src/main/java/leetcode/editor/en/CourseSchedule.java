//There are a total of numCourses courses you have to take, labeled from 0 to nu
//mCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai,
// bi] indicates that you must take course bi first if you want to take course ai.
// 
//
// 
// For example, the pair [0, 1], indicates that to take course 0 you have to fir
//st take course 1. 
// 
//
// Return true if you can finish all courses. Otherwise, return false. 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: true
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0. So it is possible.
// 
//
// Example 2: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//Output: false
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0, and to take course 0 you s
//hould also have finished course 1. So it is impossible.
// 
//
// 
// Constraints: 
//
// 
// 1 <= numCourses <= 105 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// All the pairs prerequisites[i] are unique. 
// 
// Related Topics Depth-First Search Breadth-First Search Graph Topological Sort
// 
// 👍 8006 👎 313


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new CourseSchedule().new Solution();
        System.out.println(solution.canFinish(2, new int[][]{{1, 0}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = new List[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < prerequisites.length; i++) {
                int[] e = prerequisites[i];
                graph[e[0]].add(e[1]);
            }

            boolean[] visited = new boolean[numCourses];
            boolean[] onPath = new boolean[numCourses];

            boolean[] can = new boolean[]{true};
            for (int i = 0; i < numCourses; i++) {
                dfs(graph, i, visited, onPath, can);
            }
            return can[0];
        }

        private void dfs(List<Integer>[] graph, int i, boolean[] visited, boolean[] onPath, boolean[] can) {
            if (onPath[i]) can[0] = false;
            if (visited[i] || onPath[i]) {
                return;
            }

            visited[i] = true;
            onPath[i] = true;
            for (int j = 0; j < graph[i].size(); j++) {
                dfs(graph, graph[i].get(j), visited, onPath, can);
            }
            onPath[i] = false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}