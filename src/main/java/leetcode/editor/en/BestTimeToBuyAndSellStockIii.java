//You are given an array prices where prices[i] is the price of a given stock on
// the ith day. 
//
// Find the maximum profit you can achieve. You may complete at most two transac
//tions. 
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you m
//ust sell the stock before you buy again). 
//
// 
// Example 1: 
//
// 
//Input: prices = [3,3,5,0,0,3,1,4]
//Output: 6
//Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 
//3-0 = 3.
//Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
// 
//
// Example 2: 
//
// 
//Input: prices = [1,2,3,4,5]
//Output: 4
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 
//5-1 = 4.
//Note that you cannot buy on day 1, buy on day 2 and sell them later, as you ar
//e engaging multiple transactions at the same time. You must sell before buying a
//gain.
// 
//
// Example 3: 
//
// 
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0.
// 
//
// Example 4: 
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
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 105 
// 
// Related Topics Array Dynamic Programming 
// 👍 4428 👎 97


package leetcode.editor.en;


/**
 * 状态机的方案：https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/149383/Easy-DP-solution-using-state-machine-O(n)-time-complexity-O(1)-space-complexity
 * 因为最多交易2次，所以状态流转确定，只要依次递推相关状态就可以了，复杂度O(kn)，k表示至多交易k次
 *
 */
public class BestTimeToBuyAndSellStockIii {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIii().new Solution();
        System.out.println(solution.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxProfit2(int[] prices) {
            if (prices.length == 0) return 0;
            int s0, s1=-prices[0], s2=Integer.MIN_VALUE, s3=Integer.MIN_VALUE, s4=Integer.MIN_VALUE;
            for (int i = 1; i < prices.length; i++) {
                s1 = Math.max(s1, -prices[i]);
                s2 = Math.max(s2, s1+prices[i]); // 也可以买入马上卖出
                s3 = Math.max(s3, s2-prices[i]);
                s4 = Math.max(s4, s3+prices[i]);
            }
            return Math.max(s4, 0);
        }

        public int maxProfit(int[] prices) {
            if (prices.length <= 1) return 0;
            // f[k, ii] 一直到prices[ii]最多k次交易产生的最大收益，k=0,1,2
            // f[k, ii] = max(f[k, ii-1], prices[ii] - prices[jj] + f[k-1, jj]) { jj in range of [0, ii-1] }
            //          = max(f[k, ii-1], prices[ii] + max(f[k-1, jj] - prices[jj])) 在jj处买入，在ii处卖出
            // f[0, ii] = 0; 0 times transation makes 0 profit 初始化，0次交易在所有价格处收益为0
            int[][] f = new int[3][prices.length];

            int k =2;
            int maxPro=0;
            for (int kk = 1; kk <= k; kk++) {
                int tmpMax = f[k-1][0]-prices[0];
                for (int ii = 1; ii < prices.length; ii++) {
                    f[kk][ii] =Math.max(f[kk][ii-1], prices[ii] + tmpMax);
//                    只和[kk-1][ii]有关，所以不需要n次遍历
                    tmpMax = Math.max(tmpMax,f[kk-1][ii]-prices[ii]);
                    maxPro = Math.max(maxPro, f[kk][ii]);
                }
            }
            return maxPro;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}