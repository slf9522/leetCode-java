//There are n cars going to the same destination along a one-lane road. The dest
//ination is target miles away. 
//
// You are given two integer array position and speed, both of length n, where p
//osition[i] is the position of the ith car and speed[i] is the speed of the ith c
//ar (in miles per hour). 
//
// A car can never pass another car ahead of it, but it can catch up to it and d
//rive bumper to bumper at the same speed. The faster car will slow down to match 
//the slower car's speed. The distance between these two cars is ignored (i.e., th
//ey are assumed to have the same position). 
//
// A car fleet is some non-empty set of cars driving at the same position and sa
//me speed. Note that a single car is also a car fleet. 
//
// If a car catches up to a car fleet right at the destination point, it will st
//ill be considered as one car fleet. 
//
// Return the number of car fleets that will arrive at the destination. 
//
// 
// Example 1: 
//
// 
//Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
//Output: 3
//Explanation:
//The cars starting at 10 and 8 become a fleet, meeting each other at 12.
//The car starting at 0 doesn't catch up to any other car, so it is a fleet by i
//tself.
//The cars starting at 5 (speed 3) and 3 (speed 1) become a fleet, meeting each 
//other at 6. The fleet moves at speed 1 until it reaches target.
//Note that no other cars meet these fleets before the destination, so the answe
//r is 3.
// 
//
// Example 2: 
//
// 
//Input: target = 10, position = [3], speed = [3]
//Output: 1
//Explanation: There is only one car, hence there is only one fleet.
// 
//
// Example 3: 
//
// 
//Input: target = 100, position = [0,2,4], speed = [4,2,1]
//Output: 1
//Explanation:
//The cars starting at 0 (speed 4) and 2 (speed 2) become a fleet, meeting each 
//other at 4. The fleet moves at speed 2.
//Then, the fleet (speed 2) and the car starting at 4 (speed 1) become one fleet
//, meeting each other at 6. The fleet moves at speed 1 until it reaches target.
// 
//
// 
// Constraints: 
//
// 
// n == position.length == speed.length 
// 1 <= n <= 105 
// 0 < target <= 106 
// 0 <= position[i] < target 
// All the values of position are unique. 
// 0 < speed[i] <= 106 
// 
// Related Topics Array Stack Sorting Monotonic Stack 
// 👍 1112 👎 373


package leetcode.editor.en;

import java.util.Map;
import java.util.TreeMap;

public class CarFleet {
    public static void main(String[] args) {
        Solution solution = new CarFleet().new Solution();
        System.out.println(solution.carFleet(100, new int[]{0, 2, 4}, new int[]{4, 2, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 0, 3, 5, 8, 10
         * 1, 3, 1, 4, 2
         * 12,3,7,1,1
         *
         * @param target
         * @param position
         * @param speed
         * @return
         */
        public int carFleet(int target, int[] position, int[] speed) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < position.length; i++) {
                map.put(-position[i], speed[i]);
            }
            int res = 0;
            double max = (target + map.firstKey()) / map.get(map.firstKey()) / 1.0;
            map.pollFirstEntry();
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                double t = (target + e.getKey()) / e.getValue() / 1.0;
                if (t <= max) res++;
                max = Math.max(max, t);
            }
            return position.length - res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}