//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
//
// Related Topics 字符串 回溯 👍 1404 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 复原 IP 地址
 *
 * @author JX
 * @date 2024-03-25 15:15:53
 */
public class P93_RestoreIpAddresses {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P93_RestoreIpAddresses().new Solution();
        System.out.println(solution.restoreIpAddresses("0279245587303"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            if (s.length() > 12) return res;
            dfs(s, new LinkedList<>(), 0, 0);
            return res;
        }

        private void dfs(String s, LinkedList<String> path, int start, int cnt) {
            if (cnt == 3) {
                String sub = s.substring(start);
                if (sub.length() <= 3 && valid(sub)) {
                    path.addLast(sub);
                    res.add(String.join(".", path));
                    path.removeLast();
                }
                return;
            }
            for (int i = start; i < start + 3 && i < s.length(); i++) {
                String sub = s.substring(start, i + 1);
                if (valid(sub)) {
                    path.addLast(sub);
                    dfs(s, path, i + 1, cnt + 1);
                    path.removeLast();
                }
            }
        }

        private boolean valid(String sub) {
            if (sub.isEmpty()) return false;
            char c = sub.charAt(0);
            if (c == '0') return sub.equals("0");
            int v = Integer.parseInt(sub);
            return v > 0 && v < 256;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}