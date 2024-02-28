//You are given an array prices where prices[i] is the price of a given stock 
//on the iᵗʰ day. 
//
// You want to maximize your profit by choosing a single day to buy one stock 
//and choosing a different day in the future to sell that stock. 
//
// Return the maximum profit you can achieve from this transaction. If you 
//cannot achieve any profit, return 0. 
//
// 
// Example 1: 
//
// 
//Input: prices = [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 
//6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you 
//must buy before you sell.
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
// 1 <= prices.length <= 10⁵ 
// 0 <= prices[i] <= 10⁴ 
// 
//
// Related Topics Array Dynamic Programming 👍 29969 👎 1075


package leetcode.editor.en;

/**
 * Best Time to Buy and Sell Stock
 * @author JX
 * @date 2024-02-24 08:57:46
 */
public class P121_BestTimeToBuyAndSellStock{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P121_BestTimeToBuyAndSellStock().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			res = Math.max(res, prices[i]-min);
		}
		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
