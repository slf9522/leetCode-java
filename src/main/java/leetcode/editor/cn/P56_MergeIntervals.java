//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 2261 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 合并区间
 *
 * @author JX
 * @date 2024-03-13 13:13:21
 */
public class P56_MergeIntervals {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P56_MergeIntervals().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            LinkedList<int[]> list = new LinkedList<>();
            Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

            for (int i = 0; i < intervals.length; i++) {
                if (list.size() == 0) {
                    list.addLast(intervals[i]);
                    continue;
                }
                int[] ele = intervals[i];
                int[] last = list.peekLast();
                if (last[1] >= ele[0]) {
                    last[1] = Math.max(last[1], ele[1]);
                } else {
                    list.addLast(ele);
                }
            }
            int[][] res = new int[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}