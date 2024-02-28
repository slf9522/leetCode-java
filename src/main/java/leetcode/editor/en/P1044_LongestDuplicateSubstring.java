//Given a string s, consider all duplicated substrings: (contiguous) substrings 
//of s that occur 2 or more times. The occurrences may overlap. 
//
// Return any duplicated substring that has the longest possible length. If s 
//does not have a duplicated substring, the answer is "". 
//
// 
// Example 1: 
// Input: s = "banana"
//Output: "ana"
// 
// Example 2: 
// Input: s = "abcd"
//Output: ""
// 
// 
// Constraints: 
//
// 
// 2 <= s.length <= 3 * 10⁴ 
// s consists of lowercase English letters. 
// 
//
// Related Topics String Binary Search Sliding Window Rolling Hash Suffix Array 
//Hash Function 👍 2181 👎 380


package leetcode.editor.en;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Duplicate Substring
 *
 * @author JX
 * @date 2024-02-28 10:52:50
 */
public class P1044_LongestDuplicateSubstring {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1044_LongestDuplicateSubstring().new Solution();
        System.out.println(solution.longestDupSubstring("banana"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        long[] h, p;

        public String longestDupSubstring(String s) {
            int P = 1313131, n = s.length();
            h = new long[n + 10];
            p = new long[n + 10];
            p[0] = 1;
            for (int i = 0; i < n; i++) {
                p[i + 1] = p[i] * P;
                h[i + 1] = h[i] * P + s.charAt(i);
            }
            String ans = "";
            int l = 0, r = n;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                String t = check(s, mid);
                if (t.length() != 0) l = mid;
                else r = mid - 1;
                ans = t.length() > ans.length() ? t : ans;
            }
            return ans;
        }

        String check(String s, int len) {
            int n = s.length();
            Set<Long> set = new HashSet<>();
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                long cur = h[j] - h[i - 1] * p[j - i + 1];
                if (set.contains(cur)) return s.substring(i - 1, j);
                set.add(cur);
            }
            return "";
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
