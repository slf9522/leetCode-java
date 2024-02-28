//A valid IP address consists of exactly four integers separated by single dots.
// Each integer is between 0 and 255 (inclusive) and cannot have leading zeros. 
//
// 
// For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011
//.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses. 
// 
//
// Given a string s containing only digits, return all possible valid IP 
//addresses that can be formed by inserting dots into s. You are not allowed to reorder 
//or remove any digits in s. You may return the valid IP addresses in any order. 
//
// 
// Example 1: 
//
// 
//Input: s = "25525511135"
//Output: ["255.255.11.135","255.255.111.35"]
// 
//
// Example 2: 
//
// 
//Input: s = "0000"
//Output: ["0.0.0.0"]
// 
//
// Example 3: 
//
// 
//Input: s = "101023"
//Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 20 
// s consists of digits only. 
// 
//
// Related Topics String Backtracking 👍 5094 👎 778


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Restore IP Addresses
 *
 * @author JX
 * @date 2024-02-24 10:07:18
 */
public class P93_RestoreIpAddresses {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P93_RestoreIpAddresses().new Solution();
        System.out.println(solution.restoreIpAddresses("25525511135"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new LinkedList<>();

        public List<String> restoreIpAddresses(String s) {
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i <= 255; i++) {
                set.add(new String(String.valueOf(i)));
            }

            backTrack(s, set, 0, new LinkedList<>());
            return res;
        }

        private void backTrack(String s, HashSet<String> set, Integer start, LinkedList<String> path) {
            if (start == s.length() && path.size() == 4) {
                res.add(String.join(".", path));
            }
            for (int i = start; i < start + 3 && i < s.length(); i++) {
                String next = s.substring(start, i + 1);

                if (set.contains(next)) {
                    path.add(next);
                    backTrack(s, set, i + 1, path);
                    path.removeLast();
                } else {
                    return;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
