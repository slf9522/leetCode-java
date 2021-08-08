//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number o
//f rows like this: (you may want to display this pattern in a fixed font for bett
//er legibility) 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R
// 
//
// And then read line by line: "PAHNAPLSIIGYIR" 
//
// Write the code that will take a string and make this conversion given a numbe
//r of rows: 
//
// 
//string convert(string s, int numRows);
// 
//
// 
// Example 1: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
// 
//
// Example 2: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// Example 3: 
//
// 
//Input: s = "A", numRows = 1
//Output: "A"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of English letters (lower-case and upper-case), ',' and '.'. 
// 1 <= numRows <= 1000 
// 
// Related Topics String 
// 👍 2628 👎 6314


package leetcode.editor.en;

public class ZigzagConversion {
    public static void main(String[] args) {

        Solution solution = new ZigzagConversion().new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            StringBuffer[] nums = new StringBuffer[numRows];
            for (int i = 0; i < numRows; i++) {
                nums[i] = new StringBuffer();
            }
            int i = 0;
            while (i < s.length()) {
                for (int idx = 0; idx < numRows && i < s.length(); idx++) {
                    nums[idx].append(s.charAt(i++));
                }
                for (int idx = numRows - 2; idx >= 1 && i < s.length(); idx--) {
                    nums[idx].append(s.charAt(i++));
                }
            }

            StringBuffer res = new StringBuffer(s.length());
            for (int r = 0; r < numRows; r++) {
                res.append(nums[r]);
            }
            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}