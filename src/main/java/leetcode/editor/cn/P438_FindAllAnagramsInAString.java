//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 1398 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 找到字符串中所有字母异位词
 *
 * @author JX
 * @date 2024-03-17 10:02:13
 */
public class P438_FindAllAnagramsInAString {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P438_FindAllAnagramsInAString().new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int[] all = new int[26];
            for (int i = 0; i < p.length(); i++) {
                all[p.charAt(i) - 'a'] += 1;
            }
            int i = 0, j = 0;
            int l = s.length();
            int[] sa = new int[26];
            List<Integer> res = new ArrayList<>();
            while (j < l) {
                int c = s.charAt(j) - 'a';
                sa[c] += 1;
                boolean compare = equal(all, sa);
                if (compare) {
                    res.add(i);
                    int ci = s.charAt(i) - 'a';
                    sa[ci] -= 1;
                    i++;
                    j++;
                } else if (i > j + 1 - p.length()) {
                    j++;
                } else {
                    int ci = s.charAt(i) - 'a';
                    sa[ci] -= 1;
                    i++;
                    j++;
                }
            }
            return res;
        }

        public boolean equal(int[] p, int[] w) {
            for (int i = 0; i < p.length; i++) {
                if (p[i] != w[i]) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}