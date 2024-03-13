//给定一个整数数组
// prices，其中第 prices[i] 表示第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入: prices = [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
//
// 示例 2: 
//
// 
//输入: prices = [1]
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 1711 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 买卖股票的最佳时机含冷冻期
 *
 * @author JX
 * @date 2024-03-13 13:59:42
 */
public class P309_BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P309_BestTimeToBuyAndSellStockWithCooldown().new Solution();
        System.out.println(solution.maxProfit(new int[]{2, 1, 4}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 1) return 0;

            int l = prices.length;
            int[] buy = new int[l];
            Arrays.fill(buy, -1001);
            int[] sell = new int[l];
            Arrays.fill(sell, -1001);

            buy[0] = -prices[0];
            sell[0] = -1001;

            int res = -1001;
            for (int i = 1; i < l; i++) {
                int p = prices[i];
                for (int j = i - 1; j >= 0; j--) {
                    if (j <= i - 2 && j >= 0) {
                        buy[i] = Math.max(buy[i], sell[j] - p);
                        buy[i] = Math.max(buy[i], -p);
                    } else {
                        buy[i] = Math.max(buy[i], -p);
                    }
                    sell[i] = Math.max(sell[i], buy[j] + p);
                    res = Math.max(res, buy[i]);
                    res = Math.max(res, sell[i]);
                }
            }
            return Math.max(res, 0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}