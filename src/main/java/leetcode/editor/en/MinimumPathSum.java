//Given a m x n grid filled with non-negative numbers, find a path from top left
// to bottom right, which minimizes the sum of all numbers along its path. 
//
// Note: You can only move either down or right at any point in time. 
//
// 
// Example 1: 
//
// 
//Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
//Output: 7
//Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
// 
//
// Example 2: 
//
// 
//Input: grid = [[1,2,3],[4,5,6]]
//Output: 12
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics Array Dynamic Programming Matrix 
// 👍 5534 👎 87


package leetcode.editor.en;

import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new MinimumPathSum().new Solution();
        System.out.println(solution.minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            int[] road = grid[0];
            for (int i = 1; i < grid[0].length; i++) {
                road[i] = road[i - 1] + grid[0][i];
            }

            for (int i = 1; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (j >= 1) {
                        road[j] = grid[i][j] + Math.min(road[j], road[j - 1]);
                    } else {
                        road[j] = grid[i][j] + road[j];
                    }
                }
            }

            return road[grid[0].length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}