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
//
// Related Topics Array Matrix Simulation 👍 14259 👎 1251


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

/**
 * Spiral Matrix
 *
 * @author JX
 * @date 2024-02-28 09:32:41
 */
public class P54_SpiralMatrix {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P54_SpiralMatrix().new Solution();
        solution.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            int left = 0;
            int right = matrix[0].length-1;
            int top = 0;
            int bottom = matrix.length-1 ;

            while(left<=right&&top<=bottom){
                for(int i = left;i<=right;i++){
                    result.add(matrix[top][i]);
                }
                top++;
                for(int i = top;i<=bottom;i++){
                    result.add(matrix[i][right]);
                }
                right--;
                for(int i = right;i>=left&&top<=bottom;i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
                for(int i = bottom;i>=top&&left<=right;i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
