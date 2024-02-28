//You are given an array of non-overlapping intervals intervals where intervals[
//i] = [starti, endi] represent the start and the end of the iᵗʰ interval and 
//intervals is sorted in ascending order by starti. You are also given an interval 
//newInterval = [start, end] that represents the start and end of another interval. 
//
// Insert newInterval into intervals such that intervals is still sorted in 
//ascending order by starti and intervals still does not have any overlapping 
//intervals (merge overlapping intervals if necessary). 
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
// 
// Constraints: 
//
// 
// 0 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁵ 
// intervals is sorted by starti in ascending order. 
// newInterval.length == 2 
// 0 <= start <= end <= 10⁵ 
// 
//
// Related Topics Array 👍 9516 👎 718


package leetcode.editor.en;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Insert Interval
 *
 * @author JX
 * @date 2024-02-24 11:56:41
 */
public class P57_InsertInterval {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P57_InsertInterval().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int[][] array = Arrays.copyOf(intervals,intervals.length + 1);
            array[intervals.length] = newInterval;
            return merge(array);
        }

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
