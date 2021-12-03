//You are given an n x n 2D matrix representing an image, rotate the image by 90
// degrees (clockwise). 
//
// You have to rotate the image in-place, which means you have to modify the inp
//ut 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [[7,4,1],[8,5,2],[9,6,3]]
// 
//
// Example 2: 
//
// 
//Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// Example 3: 
//
// 
//Input: matrix = [[1]]
//Output: [[1]]
// 
//
// Example 4: 
//
// 
//Input: matrix = [[1,2],[3,4]]
//Output: [[3,1],[4,2]]
// 
//
// 
// Constraints: 
//
// 
// matrix.length == n 
// matrix[i].length == n 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
// Related Topics Array Math Matrix 
// 👍 6011 👎 378


package leetcode.editor.en;

import java.util.Arrays;
import java.util.Collections;

//https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0048.Rotate-Image/
public class RotateImage {
    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();
        solution.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
//            按列遍历
            for (int i = 0; i < n; i++) {
                swap(matrix, i);
            }

            for (int i = 0; i < n; i++) {
                symmetry(matrix, i);
            }
        }

        private void symmetry(int[][] matrix, int i) {
            int j = 0;
            while (j <= i) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
                j++;
            }
        }

        private void swap(int[][] matrix, int i) {
            int j = 0;
            int l = matrix.length;
            while (j < l / 2) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[l - 1 - j][i];
                matrix[l - 1 - j][i] = tmp;
                j++;
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}