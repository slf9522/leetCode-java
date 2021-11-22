//You are given an array prices where prices[i] is the price of a given stock on
// the ith day. 
//
// You want to maximize your profit by choosing a single day to buy one stock an
//d choosing a different day in the future to sell that stock. 
//
// Return the maximum profit you can achieve from this transaction. If you canno
//t achieve any profit, return 0. 
//
// 
// Example 1: 
//
// 
//Input: prices = [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 
//6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you must
// buy before you sell.
// 
//
// Example 2: 
//
// 
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transactions are done and the max profit = 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 104 
// 
// Related Topics Array Dynamic Programming 
// 👍 11960 👎 442


package leetcode.editor.en;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
        System.out.println(solution.maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int minPrice = prices[0], maxPro = 0;
            int[] res = new int[prices.length];
            for (int i = 1; i < prices.length; i++) {
//                状态转移方程：第i天的收益 = max（之前状态收益的最大值，第i天卖出的价格-之前的最低价）
                res[i] = Math.max(maxPro, prices[i] > minPrice ? prices[i] - minPrice : 0);
                maxPro = Math.max(maxPro, res[i]);
                minPrice = Math.min(minPrice, prices[i]);
            }
            return maxPro;
        }

        //        https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/39038/Kadane's-Algorithm
        //       -Since-no-one-has-mentioned-about-this-so-far-%3A)-(In-case-if-interviewer-twists-the-input)
        // 计算 difference array of prices，{1, 7, 4, 11} -> {0, 6, -3, 7} 计算价差array的连续子串最大值
        // Kadane's Algorithm
        public int maxProfit2(int[] prices) {
            int diff = 0, maxDiff = 0;
            for (int i = 1; i < prices.length; i++) {
                diff = Math.max(0, diff += prices[i] - prices[i - 1]);
                maxDiff = Math.max(maxDiff, diff);
            }
            return maxDiff;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}