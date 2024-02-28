//You are given an integer array prices where prices[i] is the price of a given 
//stock on the iᵗʰ day. 
//
// On each day, you may decide to buy and/or sell the stock. You can only hold 
//at most one share of the stock at any time. However, you can buy it then 
//immediately sell it on the same day. 
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
//Explanation: There is no way to make a positive profit, so we never buy the 
//stock to achieve the maximum profit of 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 3 * 10⁴ 
// 0 <= prices[i] <= 10⁴ 
// 
//
// Related Topics Array Dynamic Programming Greedy 👍 13124 👎 2664


package leetcode.editor.en;

/**
 * Best Time to Buy and Sell Stock II
 *
 * @author JX
 * @date 2024-02-19 21:04:20
 */
public class P122_BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P122_BestTimeToBuyAndSellStockIi().new Solution();
        System.out.println(solution.maxProfit(new int[]{1}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int l = prices.length;
            int[] buy = new int[l];
            //能初始化就初始化
            for (int i = 0; i < l; i++) {
                buy[i] = -prices[i];
            }
            int[] sell = new int[l];
            sell[0] = -10000;

            // 如果后续有计算 不要用最大最小值
            int max = -10000;
            for (int i = 1; i < l; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    buy[i] = Math.max(buy[i], sell[j] - prices[i]);
                    sell[i] = Math.max(sell[i], prices[i] + buy[j]);
                    max = Math.max(max, Math.max(buy[i], sell[i]));
                }
            }
            // 注意边界条件
            return max == -10000 ? 0 : max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
