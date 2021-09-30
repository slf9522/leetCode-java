//The complement of an integer is the integer you get when you flip all the 0's 
//to 1's and all the 1's to 0's in its binary representation. 
//
// 
// For example, The integer 5 is "101" in binary and its complement is "010" whi
//ch is the integer 2. 
// 
//
// Given an integer n, return its complement. 
//
// 
// Example 1: 
//
// 
//Input: n = 5
//Output: 2
//Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2
// in base-10.
// 
//
// Example 2: 
//
// 
//Input: n = 7
//Output: 0
//Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0
// in base-10.
// 
//
// Example 3: 
//
// 
//Input: n = 10
//Output: 5
//Explanation: 10 is "1010" in binary, with complement "0101" in binary, which i
//s 5 in base-10.
// 
//
// 
// Constraints: 
//
// 
// 0 <= n < 109 
// 
//
// 
// Note: This question is the same as 476: https://leetcode.com/problems/number-
//complement/ 
// Related Topics Bit Manipulation 
// 👍 516 👎 49


package leetcode.editor.en;

/**
 * https://www.cnblogs.com/zhangziqiu/archive/2011/03/30/computercode.html 原码补码知识
 * 正数原码、补码、反码都是自己
 * 负数反码：其原码的基础上, 符号位不变，其余各个位取反，负数补码：符号位不变, 其余各位取反, 最后+1
 * [-1] = [10000001]原 = [11111110]反 = [11111111]补
 * 机器可以只有加法而没有减法，计算机内部不使用原码表示一个数；补码的出现, 解决了0的符号以及两个编码的问题
 */
public class ComplementOfBase10Integer {
    public static void main(String[] args) {
        Solution solution = new ComplementOfBase10Integer().new Solution();
        System.out.println(solution.bitwiseComplement2(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int bitwiseComplement(int n) {
//            特例
            if (n == 0) return 1;
            int tmp = 1;
//            寻找n的最高位
            while ((tmp & n) > 0 || tmp <= n) tmp = tmp << 1;
//            最高位以上的都置为0，最高位以下的都为1
            return (~n) & (tmp - 1);
        }

        //          todo
        public int bitwiseComplement2(int N) {
            if (N == 0) return 1;
            int k = N;
            k = k | k >> 1;
            k = k | k >> 2;
            k = k | k >> 4;
            k = k | k >> 8;
            k = k | k >> 16;
            return N ^ k;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}