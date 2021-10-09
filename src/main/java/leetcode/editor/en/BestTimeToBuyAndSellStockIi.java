//You are given an integer array prices where prices[i] is the price of a given 
//stock on the ith day. 
//
// On each day, you may decide to buy and/or sell the stock. You can only hold a
//t most one share of the stock at any time. However, you can buy it then immediat
//ely sell it on the same day. 
//
// Find and return the maximum profit you can achieve. 
//
// 
// Example 1: 
//
// 
//Input: prices = [7,1,5,3,6,4]
//Output: 7
//Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 
//5-1 = 4.
//Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
//
//Total profit is 4 + 3 = 7.
// 
//
// Example 2: 
//
// 
//Input: prices = [1,2,3,4,5]
//Output: 4
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 
//5-1 = 4.
//Total profit is 4.
// 
//
// Example 3: 
//
// 
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: There is no way to make a positive profit, so we never buy the st
//ock to achieve the maximum profit of 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 3 * 104 
// 0 <= prices[i] <= 104 
// 
// Related Topics Array Dynamic Programming Greedy 
// 👍 5458 👎 2193


package leetcode.editor.en;

/**
 * 1、选取上升坡段，https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/discuss/208241/Explanation-for-the-dummy
 * -like-me.
 * 2、动态规划，每个时间点只有两种状态，hold和not hold https://leetcode
 * .com/problems/best-time-to-buy-and-sell-stock-ii/discuss/803206/Python-O(n)-by-DP-w-Visualization
 */
public class BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIi().new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit2(int[] prices) {
            int l = prices.length, sum = 0, i = 0;
//           循环表示选取买入时机，所以上限是l-1
            while (i < l - 1) {
//                prices[l-1]会先加1再减1，所以不用特判
                while (i + 1 < l && prices[i] >= prices[i + 1]) i++;
                sum -= prices[i];

                while (i + 1 < l && prices[i] < prices[i + 1]) i++;
                sum += prices[i];
            }
            return sum;
        }

        public int maxProfit(int[] prices) {
            int l = prices.length;
            int hold = Integer.MIN_VALUE;
            int notHold = 0;
            for (int i = 0; i < l; i++) {
                hold = Math.max(hold, notHold - prices[i]);
                notHold = Math.max(hold + prices[i], notHold);
            }
            return prices.length == 1 ? 0 : notHold;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}