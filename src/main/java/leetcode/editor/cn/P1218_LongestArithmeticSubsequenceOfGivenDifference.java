//给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 
//difference 。 
//
// 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,4], difference = 1
//输出：4
//解释：最长的等差子序列是 [1,2,3,4]。 
//
// 示例 2： 
//
// 
//输入：arr = [1,3,5,7], difference = 1
//输出：1
//解释：最长的等差子序列是任意单个元素。
// 
//
// 示例 3： 
//
// 
//输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
//输出：4
//解释：最长的等差子序列是 [7,5,3,1]。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10⁵ 
// -10⁴ <= arr[i], difference <= 10⁴ 
// 
//
// Related Topics 数组 哈希表 动态规划 👍 287 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 最长定差子序列
 *
 * @author JX
 * @date 2024-04-03 09:55:55
 */
public class P1218_LongestArithmeticSubsequenceOfGivenDifference {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1218_LongestArithmeticSubsequenceOfGivenDifference().new Solution();
        System.out.println(solution.longestSubsequence(new int[]{1, 2, 3, 4}, 1));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubsequence(int[] arr, int difference) {
            int l = arr.length;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(arr[0], 1);
            int res = 1;
            for (int i = 1; i < l; i++) {
                int v = 1;
                if (map.containsKey(arr[i] - difference)) {
                    int j = map.get(arr[i] - difference);
                    v = Math.max(v, j + 1);
                }
                map.putIfAbsent(arr[i], v);
                if (v > map.get(arr[i])) {
                    map.put(arr[i], v);
                }
                res = Math.max(res, v);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}