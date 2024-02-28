//Given an array of intervals where intervals[i] = [starti, endi], merge all 
//overlapping intervals, and return an array of the non-overlapping intervals that 
//cover all the intervals in the input. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics Array Sorting 👍 21648 👎 753


package leetcode.editor.en;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Merge Intervals
 *
 * @author JX
 * @date 2024-02-24 10:23:12
 */
public class P56_MergeIntervals {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P56_MergeIntervals().new Solution();
//        System.out.println(Arrays.toString(solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.toString(solution.merge(new int[][]{{1, 4}, {2, 3}})));

    }


    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            LinkedList<int[]> result = new LinkedList<>();
            int i = 0, j = 0;
            int l = intervals.length;

            result.add(intervals[i]);
            while (i < l && j < l) {
                int[] pre = intervals[i];
                while (j < l && pre[1] >= intervals[j][0]) {
                    // 选取较大值
                    pre[1] = Math.max(pre[1], intervals[j][1]);
                    j++;
                }
                if (j < l) {
                    result.add(intervals[j]);
                }
                i = j;
            }

            int[][] res = new int[result.size()][2];
            for (int k = 0; k < result.size(); k++) {
                res[k] = result.get(k);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
