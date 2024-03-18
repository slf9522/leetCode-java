//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
//
// Related Topics 数学 字符串 模拟 👍 1327 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 字符串相乘
 *
 * @author JX
 * @date 2024-03-17 09:00:06
 */
public class P43_MultiplyStrings {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P43_MultiplyStrings().new Solution();
        System.out.println(solution.multiply("123", "456"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            int l1 = num1.length();
            int l2 = num2.length();
            int[] res = new int[l1 + l2];
            Arrays.fill(res, 0);
            int cnt = 0;
            int round = 0;
            for (int i = l1 - 1; i >= 0; i--) {
                cnt = round;
                for (int j = l2 - 1; j >= 0; j--) {
                    int tmp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                    //都有可能发生进位
                    res[cnt] += tmp % 10;
                    if (res[cnt] >= 10) {
                        res[cnt] -= 10;
                        res[cnt + 1] += 1;
                    }
                    res[cnt + 1] += tmp / 10;
                    if (res[cnt + 1] >= 10) {
                        res[cnt + 1] -= 10;
                        res[cnt + 2] += 1;
                    }
                    cnt++;
                }
                round += 1;
            }

            StringBuffer sb = new StringBuffer();
            for (int i = l1 + l2 - 1; i >= 0; i--) {
                if (res[i] != 0) {
                    while (i >= 0) {
                        sb.append(res[i]);
                        i--;
                    }
                    return sb.toString();
                }
            }
            return "0";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}