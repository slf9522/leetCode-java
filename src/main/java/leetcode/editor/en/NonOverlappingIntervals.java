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
// ð 3011 ð 84


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
        // è¾¹çæ¡ä»¶æ¯è¾ææï¼ï¼
        public int eraseOverlapInterval(int[][] intervals) {
            // åæç§startååºï¼åæç§endååº
            Arrays.sort(intervals, (a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
            // ç»è®¡å¯ä»¥å è¿å»çï¼åå§å¼ä¸º1
            int cnt = 1;
            // ä¿çä¸ä¸ä¸ªè¢«å è¿å»çæ®µï¼åååé¢çåæ¯è¾
            int preStart = intervals[0][0];
            int preEnd = intervals[0][1];

            for (int i = 1; i < intervals.length; i++) {
                int[] e = intervals[i];
                // endååºï¼æä»¥ç¥è¿
                if (preStart == e[0]) {
                    continue;
//                    å¤§äºstartï¼ä½æ¯endè¦å°
                } else if (preEnd > e[0] && preEnd <= e[1]) {
                    continue;
//                    æ´æ°å°ä¸ä¸ä¸ªåç»ï¼æ³¨æendå³ä½¿ä¸æ ·ä¹è¦æ´æ°startï¼æ¹ä¾¿ä¸ä¸ä¸ªåç»éå
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

        // æç§endæåºï¼ååªè¦æ¯è¾startå³å¯
        public int eraseOverlapIntervals(int[][] intervals) {
            // åæç§startååºï¼åæç§endååº
            Arrays.sort(intervals, (a, b) -> a[1] - b[1] == 0 ? a[0] - b[0] : a[1] - b[1]);
            // ç»è®¡å¯ä»¥å è¿å»çï¼åå§å¼ä¸º1
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