//There are a total of numCourses courses you have to take, labeled from 0 to 
//numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai,
// bi] indicates that you must take course bi first if you want to take course ai.
// 
//
// 
// For example, the pair [0, 1], indicates that to take course 0 you have to 
//first take course 1. 
// 
//
// Return the ordering of courses you should take to finish all courses. If 
//there are many valid answers, return any of them. If it is impossible to finish all 
//courses, return an empty array. 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: [0,1]
//Explanation: There are a total of 2 courses to take. To take course 1 you 
//should have finished course 0. So the correct course order is [0,1].
// 
//
// Example 2: 
//
// 
//Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//Output: [0,2,1,3]
//Explanation: There are a total of 4 courses to take. To take course 3 you 
//should have finished both courses 1 and 2. Both courses 1 and 2 should be taken 
//after you finished course 0.
//So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3
//].
// 
//
// Example 3: 
//
// 
//Input: numCourses = 1, prerequisites = []
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= numCourses * (numCourses - 1) 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// ai != bi 
// All the pairs [ai, bi] are distinct. 
// 
//
// Related Topics Depth-First Search Breadth-First Search Graph Topological 
//Sort 👍 10484 👎 335


package leetcode.editor.en;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Course Schedule II
 *
 * @author JX
 * @date 2024-03-04 18:18:41
 */
public class P210_CourseScheduleIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P210_CourseScheduleIi().new Solution();
        System.out.println(solution.findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            Set<Integer> visited = new HashSet<>();
            LinkedList<Integer> list = new LinkedList<>();

            if (prerequisites.length == 0) return new int[]{};

            Arrays.sort(prerequisites, Comparator.comparingInt(a -> a[1]));


            int l = prerequisites.length;
            visited.add(prerequisites[0][1]);
            list.addLast(prerequisites[0][1]);

            for (int i = 0; i < l; ) {
				int[] dep = prerequisites[i];
                Set<Integer> required = new HashSet<>();
                required.add(dep[1]);
                while(i<l && prerequisites[i][0] == dep[0]){
                    required.add(prerequisites[i][1]);
                    i++;
                }
                if (visited.containsAll(required)){
                    list.addLast(dep[0]);
                    visited.add(dep[0]);
                } else {
                    return new int[0];
                }
            }
            Set<Integer> all = IntStream.rangeClosed(0, numCourses-1).boxed().collect(Collectors.toSet());
            all.removeAll(visited);

            int[] res = new int[numCourses];
            int i = 0;
            for (; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            for (Integer next: all) {
                res[i++] = next;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
