//A robot is located at the top-left corner of a m x n grid (marked 'Start' in t
//he diagram below). 
//
// The robot can only move either down or right at any point in time. The robot 
//is trying to reach the bottom-right corner of the grid (marked 'Finish' in the d
//iagram below). 
//
// Now consider if some obstacles are added to the grids. How many unique paths 
//would there be? 
//
// An obstacle and space is marked as 1 and 0 respectively in the grid. 
//
// 
// Example 1: 
//
// 
//Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//Output: 2
//Explanation: There is one obstacle in the middle of the 3x3 grid above.
//There are two ways to reach the bottom-right corner:
//1. Right -> Right -> Down -> Down
//2. Down -> Down -> Right -> Right
// 
//
// Example 2: 
//
// 
//Input: obstacleGrid = [[0,1],[0,0]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// m == obstacleGrid.length 
// n == obstacleGrid[i].length 
// 1 <= m, n <= 100 
// obstacleGrid[i][j] is 0 or 1. 
// 
// Related Topics Array Dynamic Programming Matrix 
// 👍 3438 👎 316


package leetcode.editor.en;

import java.util.Arrays;

public class UniquePathsIi {
    public static void main(String[] args) {
        Solution solution = new UniquePathsIi().new Solution();
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{{1, 0}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {

            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;

            for (int i = 0; i < obstacleGrid.length; i++) {
                for (int j = 0; j < obstacleGrid[i].length; j++) {
                    if (i == 0) {
                        if ((j >= 1 && obstacleGrid[i][j - 1] == 0) || obstacleGrid[i][j] != 0) {
                            obstacleGrid[i][j] = 0;
                        } else {
                            obstacleGrid[i][j] = 1;
                        }
                    } else if (j >= 1) {
                        obstacleGrid[i][j] = obstacleGrid[i][j] != 0 ? 0 :
                                (obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1]);
                    } else {
                        obstacleGrid[i][j] = obstacleGrid[i][j] != 0 ? 0 : (obstacleGrid[i - 1][j]);
                    }
                }
            }
            return obstacleGrid[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}