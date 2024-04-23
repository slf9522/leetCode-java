//有一个书店老板，他的书店开了 n 分钟。每分钟都有一些顾客进入这家商店。给定一个长度为 n 的整数数组 customers ，其中 customers[i]
// 是在第 i 分钟开始时进入商店的顾客数量，所有这些顾客在第 i 分钟结束后离开。 
//
// 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 
//
// 当书店老板生气时，那一分钟的顾客就会不满意，若老板不生气则顾客是满意的。 
//
// 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 minutes 分钟不生气，但却只能使用一次。 
//
// 请你返回 这一天营业下来，最多有多少客户能够感到满意 。 
//
// 示例 1： 
//
// 
//输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
//输出：16
//解释：书店老板在最后 3 分钟保持冷静。
//感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
// 
//
// 示例 2： 
//
// 
//输入：customers = [1], grumpy = [0], minutes = 1
//输出：1 
//
// 
//
// 提示： 
//
// 
// n == customers.length == grumpy.length 
// 1 <= minutes <= n <= 2 * 10⁴ 
// 0 <= customers[i] <= 1000 
// grumpy[i] == 0 or 1 
// 
//
// Related Topics 数组 滑动窗口 👍 281 👎 0


package leetcode.editor.cn;

/**
 * 爱生气的书店老板
 *
 * @author JX
 * @date 2024-04-23 08:31:40
 */
public class P1052_GrumpyBookstoreOwner {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1052_GrumpyBookstoreOwner().new Solution();
        System.out.println(solution.maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
            int sum = 0;
            // 先把老板不生气的顾客加起来
            for (int i = 0; i < customers.length; i++) {
                if (grumpy[i] == 0) {
                    sum += customers[i];
                }
            }

            // 找固定长度连续数组的最大和，同时要过滤掉之前不生气的顾客
            int patch = 0;
            int tmp = 0;
            for (int i = 0; i < minutes; i++) {
                if (grumpy[i] == 1) {
                    tmp += customers[i];
                }
                patch = Math.max(patch, tmp);
            }
            for (int i = minutes; i < customers.length; i++) {
                if (grumpy[i - minutes] == 1) tmp -= customers[i - minutes];
                if (grumpy[i] == 1) tmp += customers[i];
                patch = Math.max(patch, tmp);
            }
            return sum + patch;
        }

        public int maxSatisfied2(int[] customers, int[] grumpy, int minutes) {
            int n = customers.length, res = 0, l = 0, r = 0, sum = 0, max = 0;
            // 0 ^ 1 = 1
            for (int i = 0; i < n; i++) res += customers[i] * (grumpy[i] ^ 1);
            while (r < n) {
                // 加上右边的值，减去左边的值
                sum += customers[r] * grumpy[r] - (r - l + 1 > minutes ? customers[l] * grumpy[l++] : 0);
                max = Math.max(max, sum);
                r++;
            }
            return res + max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}