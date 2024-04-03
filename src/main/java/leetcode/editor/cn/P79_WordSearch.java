//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
//
// Related Topics 数组 字符串 回溯 矩阵 👍 1795 👎 0


package leetcode.editor.cn;

/**
 * 单词搜索
 *
 * @author JX
 * @date 2024-03-28 17:51:51
 */
public class P79_WordSearch {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P79_WordSearch().new Solution();
//        System.out.println(solution.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
        System.out.println(solution.exist(new char[][]{{'a'}}, "a"));

    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            int row = board.length;
            int col = board[0].length;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    boolean flag = existBT(board, i, j, word, 0);
                    if (flag) return true;
                }
            }
            return false;
        }

        private boolean existBT(char[][] board, int i, int j, String word, int start) {
            // 回溯首先判断终止条件
            if (start == word.length()) return true;
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
            if (board[i][j] != '0' && board[i][j] == word.charAt(start)) {
                char tmp = board[i][j];
                board[i][j] = '0';
                int[] direction = new int[]{1, 0, -1, 0, 1};
                for (int k = 0; k < 4; k++) {
                    boolean sub = existBT(board, i + direction[k], j + direction[k + 1], word, start + 1);
                    if (sub) {
                        return true;
                    }
                }
                board[i][j] = tmp;
            }
            return false;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}