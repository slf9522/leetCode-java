//There is a robot on an m x n grid. The robot is initially located at the top-
//left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right 
//corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at 
//any point in time. 
//
// Given the two integers m and n, return the number of possible unique paths 
//that the robot can take to reach the bottom-right corner. 
//
// The test cases are generated so that the answer will be less than or equal 
//to 2 * 10⁹. 
//
// 
// Example 1: 
// 
// 
//Input: m = 3, n = 7
//Output: 28
// 
//
// Example 2: 
//
// 
//Input: m = 3, n = 2
//Output: 3
//Explanation: From the top-left corner, there are a total of 3 ways to reach 
//the bottom-right corner:
//1. Right -> Down -> Down
//2. Down -> Down -> Right
//3. Down -> Right -> Down
// 
//
// 
// Constraints: 
//
// 
// 1 <= m, n <= 100 
// 
//
// Related Topics Math Dynamic Programming Combinatorics 👍 16232 👎 428


package leetcode.editor.en;

/**
 * Unique Paths
 *
 * @author JX
 * @date 2024-02-24 09:59:37
 */
public class P62_UniquePaths {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P62_UniquePaths().new Solution();
        System.out.println(solution.uniquePaths(3,2));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            int[] dp = new int[n];
            // m = 0
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
            }
            // m = 1
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[j] = dp[j - 1] + dp[j];
                }
            }
            return dp[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
