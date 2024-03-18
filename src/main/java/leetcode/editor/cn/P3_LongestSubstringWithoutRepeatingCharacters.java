//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 10036 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 无重复字符的最长子串
 *
 * @author JX
 * @date 2024-03-17 08:36:25
 */
public class P3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P3_LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("tmmzuxt"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {

            int l = s.length();
            if (l == 0) return 0;

            int i = 0;
            Map<Character, Integer> map = new HashMap<>();
            map.put(s.charAt(i), i);
            int j = i + 1;

            int window = 1;
            while (j < l) {
                char c = s.charAt(j);
                // if else 完全分开
                if (map.containsKey(c)) {
                    window = Math.max(window, j - i); //j 不放进去
                    int index = map.get(c) + 1;
                    //要把这之前的都移除掉
                    for (; i < index; i++) {
                        if(map.containsKey(s.charAt(i))) {
                            map.remove(s.charAt(i));
                        }
                    }
                    map.put(c, j);
                    j++;
                } else {
                    window = Math.max(window, j - i + 1); //j 放进去
                    map.put(c, j);
                    j++;
                }
            }
            return window;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}