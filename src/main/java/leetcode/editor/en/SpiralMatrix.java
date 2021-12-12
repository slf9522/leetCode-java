//Given an m x n matrix, return all elements of the matrix in spiral order. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics Array Matrix Simulation 
// 👍 5577 👎 745


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        System.out.println(solution.spiralOrder(new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {11, 12, 13, 14, 15, 16, 17, 18, 19, 20}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int face = 0;
            int i = 0, j = 0;
            int t = Integer.MAX_VALUE;
            List<Integer> res = new ArrayList<>();
            while (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
                if (matrix[i][j] == t) {
                    break;
                } else {
                    res.add(matrix[i][j]);
                }

                matrix[i][j] = t;

                if ((face == 0 && (j + 1 == matrix[0].length || matrix[i][j + 1] == t))
                        || (face == 1 && (i + 1 == matrix.length || matrix[i + 1][j] == t))
                        || (face == 2 && (j - 1 == -1 || matrix[i][j - 1] == t))
                        || (face == 3 && (i - 1 == -1 || matrix[i - 1][j] == t))) {
                    face = (face + 1) % 4;
                }

                if (face == 0) {
                    j++;
                } else if (face == 1) {
                    i++;
                } else if (face == 2) {
                    j--;
                } else {
                    i--;
                }

            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}