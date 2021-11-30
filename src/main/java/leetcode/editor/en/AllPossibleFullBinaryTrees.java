//Given an integer n, return a list of all possible full binary trees with n nod
//es. Each node of each tree in the answer must have Node.val == 0. 
//
// Each element of the answer is the root node of one possible tree. You may ret
//urn the final list of trees in any order. 
//
// A full binary tree is a binary tree where each node has exactly 0 or 2 childr
//en. 
//
// 
// Example 1: 
//
// 
//Input: n = 7
//Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,
//0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: [[0,0,0]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 
// Related Topics Dynamic Programming Tree Recursion Memoization Binary Tree 
// 👍 2120 👎 163


package leetcode.editor.en;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPossibleFullBinaryTrees {
    public static void main(String[] args) {
        Solution solution = new AllPossibleFullBinaryTrees().new Solution();
        System.out.println(solution.allPossibleFBT(7));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<TreeNode> allPossibleFBT(int n) {
            if (n == 1) return Arrays.asList(new TreeNode(0));

            List<TreeNode> res = new ArrayList<>();
            for (int i = 1; i < n - 1; i++) {
                List<TreeNode> left = allPossibleFBT(i);
                List<TreeNode> right = allPossibleFBT(n - i - 1);

                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        TreeNode root = new TreeNode(0);
                        root.left = left.get(j);
                        root.right = right.get(k);
                        res.add(root);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}