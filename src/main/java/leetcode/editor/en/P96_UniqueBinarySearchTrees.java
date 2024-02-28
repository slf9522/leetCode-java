//Given an integer n, return the number of structurally unique BST's (binary 
//search trees) which has exactly n nodes of unique values from 1 to n. 
//
// 
// Example 1: 
// 
// 
//Input: n = 3
//Output: 5
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 19 
// 
//
// Related Topics Math Dynamic Programming Tree Binary Search Tree Binary Tree ?
//? 10173 👎 395


package leetcode.editor.en;

/**
 * Unique Binary Search Trees
 *
 * @author JX
 * @date 2024-02-19 20:07:47
 */
public class P96_UniqueBinarySearchTrees {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P96_UniqueBinarySearchTrees().new Solution();
        System.out.println(solution.numTrees(4));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int numTrees(int n) {
            int[] mem = new int[n+1];
            return helper(0, n, mem);
        }

        private int helper(int start, int end, int[] mem) {
            if (start == end) return 1;
            if (mem[end - start] != 0) return mem[end - start];
            int res = 0;
            for (int i = start; i < end; i++) {
                res += helper(start, i, mem) * helper(i + 1, end, mem);
            }
            mem[end - start] = res;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
