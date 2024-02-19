//Given two integer arrays preorder and inorder where preorder is the preorder 
//traversal of a binary tree and inorder is the inorder traversal of the same tree,
// construct and return the binary tree. 
//
// 
// Example 1: 
// 
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// Example 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder and inorder consist of unique values. 
// Each value of inorder also appears in preorder. 
// preorder is guaranteed to be the preorder traversal of the tree. 
// inorder is guaranteed to be the inorder traversal of the tree. 
// 
//
// Related Topics Array Hash Table Divide and Conquer Tree Binary Tree 👍 14500 
//👎 463


package leetcode.editor.en;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 *
 * @author DY
 * @date 2024-02-08 19:24:13
 */
public class P105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();

    }

//力扣代码
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> inMap = new HashMap<>();

            for (int i = 0; i < inorder.length; i++) {
                inMap.put(inorder[i], i);
            }
            return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        }

        private TreeNode build(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2, Map<Integer, Integer> inMap) {
            if (l1 > r1) return null;

            TreeNode root = new TreeNode(preorder[l1]);

            int inMidIndex = inMap.get(preorder[l1]);
            int leftSize = inMidIndex - l2;


            TreeNode left = build(preorder, l1 + 1, leftSize - l1, inorder, l2, inMidIndex - 1, inMap);
            TreeNode right = build(preorder, leftSize - l1 + 1, r1, inorder, inMidIndex + 1, r2, inMap);

            root.left = left;
            root.right = right;
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
