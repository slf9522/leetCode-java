//You are given an array prices where prices[i] is the price of a given stock on
// the ith day. 
//
// Find the maximum profit you can achieve. You may complete as many transaction
//s as you like (i.e., buy one and sell one share of the stock multiple times) wit
//h the following restrictions: 
//
// 
// After you sell your stock, you cannot buy stock on the next day (i.e., cooldo
//wn one day). 
// 
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you m
//ust sell the stock before you buy again). 
//
// 
// Example 1: 
//
// 
//Input: prices = [1,2,3,0,2]
//Output: 3
//Explanation: transactions = [buy, sell, cooldown, buy, sell]
// 
//
// Example 2: 
//
// 
//Input: prices = [1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
// Related Topics Array Dynamic Programming 
// 👍 4315 👎 140


package leetcode.editor.en;

public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) return 0;
            // hold[i]= Math.max(hold[i-1],notHold[i-2]-price[i])
            // notHold[i] = Math.max(notHold[i-1], hold[i]+price[i])
            int l = prices.length;
            int hold = Integer.MIN_VALUE;
            int notHold = 0, notHoldPre = notHold;
            for (int i = 0; i < l; i++) {
                hold = Math.max(hold, notHoldPre - prices[i]);
                notHoldPre = notHold;
                notHold = Math.max(hold + prices[i], notHold);
            }
            return prices.length == 1 ? 0 : notHold;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}