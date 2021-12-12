//Given a string s containing only digits, return all possible valid IP addresse
//s that can be obtained from s. You can return them in any order. 
//
// A valid IP address consists of exactly four integers, each integer is between
// 0 and 255, separated by single dots and cannot have leading zeros. For example,
// "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.
//168.1.312" and "192.168@1.1" are invalid IP addresses. 
//
// 
// Example 1: 
// Input: s = "25525511135"
//Output: ["255.255.11.135","255.255.111.35"]
// Example 2: 
// Input: s = "0000"
//Output: ["0.0.0.0"]
// Example 3: 
// Input: s = "1111"
//Output: ["1.1.1.1"]
// Example 4: 
// Input: s = "010010"
//Output: ["0.10.0.10","0.100.1.0"]
// Example 5: 
// Input: s = "101023"
//Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
// 
// Constraints: 
//
// 
// 0 <= s.length <= 3000 
// s consists of digits only. 
// 
// Related Topics String Backtracking 
// 👍 2222 👎 612


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
        System.out.println(solution.restoreIpAddresses("25525511135"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();
            restoreIpAddresses(s, 0, res, "", 0);
            return res;
        }

        public void restoreIpAddresses(String s, int cnt, List<String> res, String reserve, int index) {
            if (cnt == 4) {
                if (index == s.length()) {
                    res.add(reserve);
                }
                return;
            }

            for (int i = 1; i <= 3; i++) {
                if (index + i > s.length()) break;
                String subStr = s.substring(index, index + i);
                if (valid(subStr)) {
                    String tmp = cnt == 3 ? "" : ".";
                    restoreIpAddresses(s, cnt + 1, res, reserve + subStr + tmp, i + index);
                }
            }
        }

        public boolean valid(String s) {
            return s.length() <= 3 && s.length() != 0 && (s.charAt(0) != '0' || s.length() <= 1) && Integer.parseInt(s) <= 255;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}