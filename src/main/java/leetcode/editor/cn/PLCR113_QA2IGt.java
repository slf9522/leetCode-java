//现在总共有 numCourses 门课需要选，记为 0 到 numCourses-1。 
//
// 给定一个数组 prerequisites ，它的每一个元素 prerequisites[i] 表示两门课程之间的先修顺序。 例如 
//prerequisites[i] = [ai, bi] 表示想要学习课程 ai ，需要先完成课程 bi 。 
//
// 请根据给出的总课程数 numCourses 和表示先修顺序的 prerequisites 得出一个可行的修课序列。 
//
// 可能会有多个正确的顺序，只要任意返回一种就可以了。如果不可能完成所有课程，返回一个空数组。 
//
// 
//
// 示例 1: 
//
// 
//输入: numCourses = 2, prerequisites = [[1,0]] 
//输出: [0,1]
//解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。 
//
// 示例 2: 
//
// 
//输入: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//输出: [0,1,2,3] or [0,2,1,3]
//解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
// 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
// 
//
// 示例 3: 
//
// 
//输入: numCourses = 1, prerequisites = [] 
//输出: [0]
//解释: 总共 1 门课，直接修第一门课就可。 
//
// 
//
// 提示: 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= numCourses * (numCourses - 1) 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// ai != bi 
// prerequisites 中不存在重复元素 
// 
//
// 
//
// 
// 注意：本题与主站 210 题相同：https://leetcode-cn.com/problems/course-schedule-ii/ 
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 55 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 课程表 II
 *
 * @author JX
 * @date 2024-04-07 08:05:31
 */
public class PLCR113_QA2IGt {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PLCR113_QA2IGt().new Solution();
//        System.out.println(solution.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}));
//        System.out.println(solution.findOrder(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(solution.findOrder(3, new int[][]{{0, 1}, {0, 2}, {1, 2}}));


    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            Map<Integer, List<Integer>> dep = new HashMap<>();
            int[] indeg = new int[numCourses];
            for (int[] pre : prerequisites) {
                dep.putIfAbsent(pre[1], new ArrayList<>());
                dep.get(pre[1]).add(pre[0]);
                indeg[pre[0]]++;
            }

            LinkedList<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (indeg[i] == 0) queue.addLast(i);
            }
            List<Integer> res = new ArrayList<>();
            while (!queue.isEmpty()) {
                int v = queue.pollFirst();
                res.add(v);
                if (dep.containsKey(v)) {
                    List<Integer> next = dep.get(v);
                    for (Integer n : next) {
                        indeg[n]--;
                        if (indeg[n] == 0) queue.addLast(n);
                    }
                } else {
                    continue;
                }
            }
            if (res.size() != numCourses) return new int[]{};
            int[] result = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                result[i] = res.get(i);
            }
            return result;
        }
    }

    class Node {
        int val;
        int cnt;

        public Node(int v, int c) {
            val = v;
            cnt = c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}