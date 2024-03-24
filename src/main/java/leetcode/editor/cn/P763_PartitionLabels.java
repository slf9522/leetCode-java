//给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。 
//
// 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。 
//
// 返回一个表示每个字符串片段的长度的列表。 
//
// 
//示例 1：
//
// 
//输入：s = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。 
//
// 示例 2： 
//
// 
//输入：s = "eccbbbbdec"
//输出：[10]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 贪心 哈希表 双指针 字符串 👍 1108 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 划分字母区间
 *
 * @author JX
 * @date 2024-03-18 08:40:31
 */
public class P763_PartitionLabels {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P763_PartitionLabels().new Solution();
        System.out.println(solution.partitionLabels("eccbbbbdec"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> partitionLabels(String s) {
            int[][] index = new int[26][2];
            for (int i = 0; i < 26; i++) {
                index[i][0] = s.length() + 1;
                index[i][1] = -1;
            }
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';
                index[c][0] = Math.min(index[c][0], i);
                index[c][1] = Math.max(index[c][1], i);
            }
            Arrays.sort(index, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            LinkedList<int[]> res = new LinkedList<>();
            for (int i = 0; i < 26; i++) {
                int[] e = index[i];
                if (e[1] != -1) {
                    if (res.isEmpty()) {
                        res.addLast(e);
                    } else {
                        int[] top = res.peekLast();
                        if (top[1] >= e[0]) {
                            top[1] = Math.max(top[1], e[1]);
                        } else {
                            res.addLast(e);
                        }
                    }
                }

            }
            List<Integer> result = new ArrayList<>();
            result.add(res.get(0)[1]+1);
            for (int i = 1; i < res.size(); i++) {
                int[] tmp = res.get(i);
                result.add(res.get(i)[1]-res.get(i-1)[1]);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}