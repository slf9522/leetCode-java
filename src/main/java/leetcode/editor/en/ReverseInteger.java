//Given a signed 32-bit integer x, return x with its digits reversed. If reversi
//ng x causes the value to go outside the signed 32-bit integer range [-231, 231 -
// 1], then return 0. 
//
// Assume the environment does not allow you to store 64-bit integers (signed or
// unsigned). 
//
// 
// Example 1: 
// Input: x = 123
//Output: 321
// Example 2: 
// Input: x = -123
//Output: -321
// Example 3: 
// Input: x = 120
//Output: 21
// Example 4: 
// Input: x = 0
//Output: 0
// 
// 
// Constraints: 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics Math 
// 👍 5251 👎 7879


package leetcode.editor.en;

public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        System.out.println(solution.reverse(-2147483412));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            if (x == 0) {
                return x;
            }
            int res = x % 10;
            x /= 10;
            while (x != 0) {
                int tmp;
                tmp = res * 10 + x % 10;
                x /= 10;
                // 提前判断是否超限
                if (x != 0 && (tmp > Integer.MAX_VALUE / 10 || tmp < Integer.MIN_VALUE / 10)) {
                    return 0;
                } else {
                    res = tmp;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}