//给定一个三角形 triangle ，找出自顶向下的最小路径和。 
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -10⁴ <= triangle[i][j] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
//
// Related Topics 数组 动态规划 👍 1317 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三角形最小路径和
 *
 * @author JX
 * @date 2024-03-07 19:17:06
 */
public class P120_Triangle {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P120_Triangle().new Solution();
        List<List<Integer>> tri = new ArrayList<>();
        tri.add(Arrays.asList(-1));
        tri.add(Arrays.asList(-2,-3));
//        tri.add(Arrays.asList(6,5,7));
//        tri.add(Arrays.asList(4,1,8,3));

        System.out.println(solution.minimumTotal(tri));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int m = triangle.size();
            int n = triangle.get(m - 1).size();
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j]=10001;
                }
            }
            dp[0][0] = triangle.get(0).get(0);
            for (int i = 1; i < m; i++) {
                List<Integer> row = triangle.get(i);
                dp[i][0] = dp[i - 1][0] + row.get(0);
                for (int j = 1; j < row.size(); j++) {
                    dp[i][j] = Math.min(dp[i - 1][j-1], dp[i-1][j]) + row.get(j);
                }
            }

            int res = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                res= Math.min(res, dp[m-1][i]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}