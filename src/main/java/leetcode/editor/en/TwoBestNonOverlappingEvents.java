//You are given a 0-indexed 2D integer array of events where events[i] = [startT
//imei, endTimei, valuei]. The ith event starts at startTimei and ends at endTimei
//, and if you attend this event, you will receive a value of valuei. You can choo
//se at most two non-overlapping events to attend such that the sum of their value
//s is maximized. 
//
// Return this maximum sum. 
//
// Note that the start time and end time is inclusive: that is, you cannot atten
//d two events where one of them starts and the other ends at the same time. More 
//specifically, if you attend an event with end time t, the next event must start 
//at or after t + 1. 
//
// 
// Example 1: 
//
// 
//Input: events = [[1,3,2],[4,5,2],[2,4,3]]
//Output: 4
//Explanation: Choose the green events, 0 and 1 for a sum of 2 + 2 = 4.
// 
//
// Example 2: 
//
// 
//Input: events = [[1,3,2],[4,5,2],[1,5,5]]
//Output: 5
//Explanation: Choose event 2 for a sum of 5.
// 
//
// Example 3: 
//
// 
//Input: events = [[1,5,3],[1,5,1],[6,6,5]]
//Output: 8
//Explanation: Choose events 0 and 2 for a sum of 3 + 5 = 8. 
//
// 
// Constraints: 
//
// 
// 2 <= events.length <= 105 
// events[i].length == 3 
// 1 <= startTimei <= endTimei <= 109 
// 1 <= valuei <= 106 
// 
// Related Topics Array Binary Search Dynamic Programming Sorting Heap (Priority
// Queue) 
// 👍 229 👎 6


package leetcode.editor.en;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * 给出一组【开始节点、结束节点、权重的数组】找出两端使得不重合，而且权重之和最大
 * 解法1：对于以events[i]开始的最大权重组合，Map<Integer, Integer> 记录大于key的最大权重
 */
public class TwoBestNonOverlappingEvents {
    public static void main(String[] args) {

        Solution solution = new TwoBestNonOverlappingEvents().new Solution();
        System.out.println(solution.maxTwoEvents(new int[][]{
                {66, 97, 90}, {98, 98, 68}, {38, 49, 63}, {91, 100, 42}, {92, 100, 22}, {1, 77, 50}, {64, 72, 97}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxTwoEvents(int[][] events) {
            // Arrays.sort是原地修改，Arrays.stream(events).sorted()返回新的列表
            Arrays.sort(events, Comparator.comparingInt(value -> value[0]));
            int res = 0;
            // map记录key>start的最大weight
            int max = 0;
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = events.length - 1; i >= 0; i--) {
                int[] event = events[i];
                int start = event[0], end = event[1], weight = event[2];
                // ceilingKey找到大于等于value的值，所以要+1
                res = Math.max(res, map.ceilingKey(end + 1) == null ? weight :
                        map.get(map.ceilingKey(end + 1)) + weight);
                max = Math.max(weight, max);
                if (map.containsKey(start) && weight > map.get(start)) {
                    map.put(start, max);
                } else if (!map.containsKey(start)) {
                    map.put(start, max);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}