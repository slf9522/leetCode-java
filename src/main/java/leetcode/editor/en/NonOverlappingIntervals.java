//Given an array of intervals intervals where intervals[i] = [starti, endi], ret
//urn the minimum number of intervals you need to remove to make the rest of the i
//ntervals non-overlapping. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
//Output: 1
//Explanation: [1,3] can be removed and the rest of the intervals are non-overla
//pping.
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,2],[1,2],[1,2]]
//Output: 2
//Explanation: You need to remove two [1,2] to make the rest of the intervals no
//n-overlapping.
// 
//
// Example 3: 
//
// 
//Input: intervals = [[1,2],[2,3]]
//Output: 0
//Explanation: You don't need to remove any of the intervals since they're alrea
//dy non-overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 105 
// intervals[i].length == 2 
// -5 * 104 <= starti < endi <= 5 * 104 
// 
// Related Topics Array Dynamic Programming Greedy Sorting 
// 👍 3011 👎 84


package leetcode.editor.en;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        Solution solution = new NonOverlappingIntervals().new Solution();
        System.out.println(solution.eraseOverlapIntervals(new int[][]{
                {1, 2}, {2, 3}, {3, 4}, {1, 3}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 边界条件比较敏感！！
        public int eraseOverlapInterval(int[][] intervals) {
            // 先按照start升序，再按照end升序
            Arrays.sort(intervals, (a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
            // 统计可以加进去的，初始值为1
            int cnt = 1;
            // 保留上一个被加进去的段，再和后面的做比较
            int preStart = intervals[0][0];
            int preEnd = intervals[0][1];

            for (int i = 1; i < intervals.length; i++) {
                int[] e = intervals[i];
                // end升序，所以略过
                if (preStart == e[0]) {
                    continue;
//                    大于start，但比end要小
                } else if (preEnd > e[0] && preEnd <= e[1]) {
                    continue;
//                    更新到下一个分组，注意end即使一样也要更新start，方便下一个分组遍历
                } else if (preEnd > e[1]) {
                    preStart = e[0];
                    preEnd = e[1];
                } else {
                    cnt++;
                    preStart = e[0];
                    preEnd = e[1];
                }
            }
            return intervals.length - cnt;
        }

        // 按照end排序，则只要比较start即可
        public int eraseOverlapIntervals(int[][] intervals) {
            // 先按照start升序，再按照end升序
            Arrays.sort(intervals, (a, b) -> a[1] - b[1] == 0 ? a[0] - b[0] : a[1] - b[1]);
            // 统计可以加进去的，初始值为1
            int cnt = 1;
            int preEnd = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                int[] e = intervals[i];
                if (preEnd <= e[0]) {
                    preEnd = e[1];
                    cnt++;
                }
            }
            return intervals.length - cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}