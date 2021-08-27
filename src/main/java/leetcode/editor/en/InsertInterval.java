//You are given an array of non-overlapping intervals intervals where intervals[
//i] = [starti, endi] represent the start and the end of the ith interval and inte
//rvals is sorted in ascending order by starti. You are also given an interval new
//Interval = [start, end] that represents the start and end of another interval. 
//
// Insert newInterval into intervals such that intervals is still sorted in asce
//nding order by starti and intervals still does not have any overlapping interval
//s (merge overlapping intervals if necessary). 
//
// Return intervals after the insertion. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//Output: [[1,5],[6,9]]
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//Output: [[1,2],[3,10],[12,16]]
//Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10]. 
//
//
// Example 3: 
//
// 
//Input: intervals = [], newInterval = [5,7]
//Output: [[5,7]]
// 
//
// Example 4: 
//
// 
//Input: intervals = [[1,5]], newInterval = [2,3]
//Output: [[1,5]]
// 
//
// Example 5: 
//
// 
//Input: intervals = [[1,5]], newInterval = [2,7]
//Output: [[1,7]]
// 
//
// 
// Constraints: 
//
// 
// 0 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 105 
// intervals is sorted by starti in ascending order. 
// newInterval.length == 2 
// 0 <= start <= end <= 105 
// 
// Related Topics Array 
// 👍 3471 👎 274


package leetcode.editor.en;

import java.util.Arrays;

public class InsertInterval {
    public static void main(String[] args) {

        Solution solution = new InsertInterval().new Solution();
        System.out.println(solution.insert(new int[][]{{1, 5}}, new int[]{0, 0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int l = intervals.length;
            if (l == 0) {
                return new int[][]{newInterval};
            }
            int[][] result = new int[l + 1][2];

            int s = newInterval[0];
            int e = newInterval[1];
            int cnt = 0;

            // 按顺序遍历，先把interval之前的插入
            int i = 0;
            for (; i < l && intervals[i][1] < s; i++) {
                result[cnt++] = intervals[i];
            }

            // 合并重复的部分
            for (result[cnt++] = newInterval; i < l && e >= intervals[i][0]; i++) {
                int[] tmp = result[cnt - 1];
                tmp[0] = Math.min(intervals[i][0], tmp[0]);
                tmp[1] = Math.max(intervals[i][1], tmp[1]);
            }

            for (; i < l; i++) {
                result[cnt++] = intervals[i];
            }

            return Arrays.copyOfRange(result, 0, cnt);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
