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
// ð 516 ð 49


package leetcode.editor.en;

/**
 * https://www.cnblogs.com/zhangziqiu/archive/2011/03/30/computercode.html åç è¡¥ç ç¥è¯
 * æ­£æ°åç ãè¡¥ç ãåç é½æ¯èªå·±
 * è´æ°åç ï¼å¶åç çåºç¡ä¸, ç¬¦å·ä½ä¸åï¼å¶ä½åä¸ªä½ååï¼è´æ°è¡¥ç ï¼ç¬¦å·ä½ä¸å, å¶ä½åä½åå, æå+1
 * [-1] = [10000001]å = [11111110]å = [11111111]è¡¥
 * æºå¨å¯ä»¥åªæå æ³èæ²¡æåæ³ï¼è®¡ç®æºåé¨ä¸ä½¿ç¨åç è¡¨ç¤ºä¸ä¸ªæ°ï¼è¡¥ç çåºç°, è§£å³äº0çç¬¦å·ä»¥åä¸¤ä¸ªç¼ç çé®é¢
 */
public class ComplementOfBase10Integer {
    public static void main(String[] args) {
        Solution solution = new ComplementOfBase10Integer().new Solution();
        System.out.println(solution.bitwiseComplement2(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int bitwiseComplement(int n) {
//            ç¹ä¾
            if (n == 0) return 1;
            int tmp = 1;
//            å¯»æ¾nçæé«ä½
            while ((tmp & n) > 0 || tmp <= n) tmp = tmp << 1;
//            æé«ä½ä»¥ä¸çé½ç½®ä¸º0ï¼æé«ä½ä»¥ä¸çé½ä¸º1
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