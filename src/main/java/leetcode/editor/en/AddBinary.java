//Given two binary strings a and b, return their sum as a binary string. 
//
// 
// Example 1: 
// Input: a = "11", b = "1"
//Output: "100"
// Example 2: 
// Input: a = "1010", b = "1011"
//Output: "10101"
// 
// 
// Constraints: 
//
// 
// 1 <= a.length, b.length <= 104 
// a and b consist only of '0' or '1' characters. 
// Each string does not contain leading zeros except for the zero itself. 
// 
// Related Topics Math String Bit Manipulation Simulation 
// 👍 3651 👎 430


package leetcode.editor.en;

public class AddBinary {
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();
        System.out.println(solution.addBinary("11", "1"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            int la = a.length() - 1, lb = b.length() - 1;
            int tmp = 0;
            StringBuilder res = new StringBuilder();
//            不能在while括号中写递减
            while (la >= 0 || lb >= 0 || tmp > 0) {
                int sum = tmp;
                if (la >= 0) sum += (a.charAt(la--) - '0');
                if (lb >= 0) sum += (b.charAt(lb--) - '0');
                // StringBuilder的插入操作
                res.insert(0, sum % 2);
                tmp = sum / 2;
            }
            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}