//Given an array of intervals where intervals[i] = [starti, endi], merge all ove
//rlapping intervals, and return an array of the non-overlapping intervals that co
//ver all the intervals in the input. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
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
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics Array Sorting 
// 👍 9023 👎 420


package leetcode.editor.en;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        System.out.println(solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            int[][] result = new int[intervals.length][2];
            // 表示下一个将要处理的输入
            int next = 1;
            result[0] = intervals[0];
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] <= result[next - 1][1]) {
                    result[next - 1][1] = Math.max(intervals[i][1], result[next - 1][1]);
                } else {
                    result[next++] = intervals[i];
                }
            }
            return Arrays.copyOfRange(result, 0, next);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}