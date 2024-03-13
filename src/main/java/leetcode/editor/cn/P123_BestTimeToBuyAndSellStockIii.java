//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入：prices = [3,3,5,0,0,3,1,4]
//输出：6
//解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2： 
//
// 
//输入：prices = [1,2,3,4,5]
//输出：4
//解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3： 
//
// 
//输入：prices = [7,6,4,3,1] 
//输出：0 
//解释：在这个情况下, 没有交易完成, 所以最大利润为 0。 
//
// 示例 4： 
//
// 
//输入：prices = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 10⁵ 
// 0 <= prices[i] <= 10⁵ 
// 
//
// Related Topics 数组 动态规划 👍 1679 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 买卖股票的最佳时机 III
 *
 * @author JX
 * @date 2024-03-13 15:11:29
 */
public class P123_BestTimeToBuyAndSellStockIii {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P123_BestTimeToBuyAndSellStockIii().new Solution();
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 4, 5}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int l = prices.length;
            if (l == 1) return 0;

            int[][] buy = new int[2][l];
            int[][] sold = new int[2][l];
            Arrays.fill(buy[0], -10001);
            Arrays.fill(buy[1], -10001);

            Arrays.fill(sold[0], -10001);
            Arrays.fill(sold[1], -10001);

            buy[0][0] = -prices[0];
            buy[0][1] = -10001;
            sold[0][0] = -10001;
            sold[0][1] = -10001;

            int res = -10001;
            for (int i = 1; i < l; i++) {
                int p = prices[i];
                buy[0][i] = Math.max(buy[0][i], -p);
                for (int j = i; j >= 0; j--) {
                    if(j<i){
                        sold[0][i]= Math.max(sold[0][i], buy[0][j] + p);
                        sold[1][i] = Math.max(sold[1][i], buy[1][j] + p);
                    }
                    buy[1][i] = Math.max(buy[1][i], sold[0][j] - p);
                }
                res = Math.max(sold[1][i], res);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}