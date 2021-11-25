//There are n people in a line queuing to buy tickets, where the 0th person is a
//t the front of the line and the (n - 1)th person is at the back of the line. 
//
// You are given a 0-indexed integer array tickets of length n where the number 
//of tickets that the ith person would like to buy is tickets[i]. 
//
// Each person takes exactly 1 second to buy a ticket. A person can only buy 1 t
//icket at a time and has to go back to the end of the line (which happens instant
//aneously) in order to buy more tickets. If a person does not have any tickets le
//ft to buy, the person will leave the line. 
//
// Return the time taken for the person at position k (0-indexed) to finish buyi
//ng tickets. 
//
// 
// Example 1: 
//
// 
//Input: tickets = [2,3,2], k = 2
//Output: 6
//Explanation: 
//- In the first pass, everyone in the line buys a ticket and the line becomes [
//1, 2, 1].
//- In the second pass, everyone in the line buys a ticket and the line becomes 
//[0, 1, 0].
//The person at position 2 has successfully bought 2 tickets and it took 3 + 3 =
// 6 seconds.
// 
//
// Example 2: 
//
// 
//Input: tickets = [5,1,1,1], k = 0
//Output: 8
//Explanation:
//- In the first pass, everyone in the line buys a ticket and the line becomes [
//4, 0, 0, 0].
//- In the next 4 passes, only the person in position 0 is buying tickets.
//The person at position 0 has successfully bought 5 tickets and it took 4 + 1 +
// 1 + 1 + 1 = 8 seconds.
// 
//
// 
// Constraints: 
//
// 
// n == tickets.length 
// 1 <= n <= 100 
// 1 <= tickets[i] <= 100 
// 0 <= k < n 
// 
// Related Topics Array Queue Simulation 
// 👍 147 👎 12


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class TimeNeededToBuyTickets {
    public static void main(String[] args) {
        Solution solution = new TimeNeededToBuyTickets().new Solution();
        System.out.println(solution.timeRequiredToBuy(new int[]{84, 49, 5, 24, 70, 77, 87, 8}, 3));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int timeRequiredToBuy(int[] tickets, int k) {
            int res = 0;
            for (int i = 0; i < tickets.length; i++) {
                int ti = tickets[i];
                if (i <= k) {
                    res += Math.min(ti, tickets[k]);
                } else {
                    res += Math.min(ti, tickets[k] - 1);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}