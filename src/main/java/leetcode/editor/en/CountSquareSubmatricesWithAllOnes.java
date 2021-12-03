//Given a m * n matrix of ones and zeros, return how many square submatrices hav
//e all ones. 
//
// 
// Example 1: 
//
// 
//Input: matrix =
//[
//  [0,1,1,1],
//  [1,1,1,1],
//  [0,1,1,1]
//]
//Output: 15
//Explanation: 
//There are 10 squares of side 1.
//There are 4 squares of side 2.
//There is  1 square of side 3.
//Total number of squares = 10 + 4 + 1 = 15.
// 
//
// Example 2: 
//
// 
//Input: matrix = 
//[
//  [1,0,1],
//  [1,1,0],
//  [1,1,0]
//]
//Output: 7
//Explanation: 
//There are 6 squares of side 1.  
//There is 1 square of side 2. 
//Total number of squares = 6 + 1 = 7.
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 300 
// 1 <= arr[0].length <= 300 
// 0 <= arr[i][j] <= 1 
// 
// Related Topics Array Dynamic Programming Matrix 
// 👍 2777 👎 45


package leetcode.editor.en;

/**
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/discuss/441306/JavaC%2B%2BPython-DP-solution
 * i,j为右下角坐标的正方形最大大小，根据正方形的嵌套关系看出递推
 */
public class CountSquareSubmatricesWithAllOnes {
    public static void main(String[] args) {
        Solution solution = new CountSquareSubmatricesWithAllOnes().new Solution();
        System.out.println(solution.countSquares(new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSquares(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int res = 0;

            // i,j为右下角坐标的正方形最大大小
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (matrix[i - 1][j - 1] == 0) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[j][j - 1], dp[i - 1][j - 1])) + 1;
                        res += dp[i][j];
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}