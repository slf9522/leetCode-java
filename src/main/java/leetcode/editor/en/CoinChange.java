//You are given an integer array coins representing coins of different denominat
//ions and an integer amount representing a total amount of money. 
//
// Return the fewest number of coins that you need to make up that amount. If th
//at amount of money cannot be made up by any combination of the coins, return -1.
// 
//
// You may assume that you have an infinite number of each kind of coin. 
//
// 
// Example 1: 
//
// 
//Input: coins = [1,2,5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
// 
//
// Example 2: 
//
// 
//Input: coins = [2], amount = 3
//Output: -1
// 
//
// Example 3: 
//
// 
//Input: coins = [1], amount = 0
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics Array Dynamic Programming Breadth-First Search 
// 👍 9321 👎 225


package leetcode.editor.en;

import java.util.Arrays;
import java.util.Map;

public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) return 0;
//            Arrays.sort(coins);
//            return coinChange(coins, amount, coins.length - 1, new HashMap<>());

            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;

            for (int i = 1; i < dp.length; i++) {
                for (int coin : coins) {
                    if (i - coin < 0) continue;
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }

        public int coinChange(int[] coins, int amount, int i, Map<Integer, Integer> map) {
            if (map.containsKey(amount)) return map.get(amount);

            int res = Integer.MAX_VALUE;
            for (int j = i; j >= 0; j--) {
                if (coins[j] > amount) continue;
                if (coins[j] == amount) {
                    res = 1;
                    break;
                }
                int tmp = coinChange(coins, amount - coins[j], i, map);
                if (tmp > 0) {
                    res = Math.min(res, 1 + tmp);
                }
            }

            res = res == Integer.MAX_VALUE ? -1 : res;
            map.put(amount, res);
            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}