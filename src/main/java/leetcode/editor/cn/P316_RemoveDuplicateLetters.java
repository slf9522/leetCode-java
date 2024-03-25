//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-
//distinct-characters 相同 
//
// Related Topics 栈 贪心 字符串 单调栈 👍 1055 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 去除重复字母
 *
 * @author JX
 * @date 2024-03-25 14:11:48
 */
public class P316_RemoveDuplicateLetters {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P316_RemoveDuplicateLetters().new Solution();
        System.out.println(solution.removeDuplicateLetters("cbacdcbc"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicateLetters(String s) {
            Map<Character, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.putIfAbsent(c, new ArrayList<>());
                map.get(c).add(i);
            }
            Set<Character> set = new HashSet<>();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (set.contains(c)) continue;
                while (stack.size() != 0 && c - stack.peek() < 0) {
                    char top = stack.peek();
                    List<Integer> indexs = map.get(top);
                    if (indexs.get(indexs.size()-1) > i) {
                        stack.pop();
                        set.remove(top);
                    } else {
                        break;
                    }
                }
                stack.push(c);
                set.add(c);
            }
            StringBuffer sb = new StringBuffer();
            for(char c: stack){
                sb.append(c);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}