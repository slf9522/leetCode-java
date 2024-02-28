//Given the root of a complete binary tree, return the number of the nodes in 
//the tree. 
//
// According to Wikipedia, every level, except possibly the last, is completely 
//filled in a complete binary tree, and all nodes in the last level are as far 
//left as possible. It can have between 1 and 2ʰ nodes inclusive at the last level h.
// 
//
// Design an algorithm that runs in less than O(n) time complexity. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,3,4,5,6]
//Output: 6
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 5 * 10⁴]. 
// 0 <= Node.val <= 5 * 10⁴ 
// The tree is guaranteed to be complete. 
// 
//
// Related Topics Binary Search Bit Manipulation Tree Binary Tree 👍 8427 👎 486
//


package leetcode.editor.en;

/**
 * Count Complete Tree Nodes
 *
 * @author JX
 * @date 2024-02-28 12:04:47
 */
public class P222_CountCompleteTreeNodes {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P222_CountCompleteTreeNodes().new Solution();
//        System.out.println(1 << 3);
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
        public int countNodes(TreeNode root) {
            if (root == null) return 0;
            int left = getDepth(root.left);
            int right = getDepth(root.right);
            int res = 0;
            if (left == right) {
                res = (1 << left) + countNodes(root.right);
            } else {
                res = (1 << right) + countNodes(root.left);
            }
            return res;
        }

        private int getDepth(TreeNode r) {
            int depth = 0;
            while (r != null) {
                depth++;
                r = r.left;
            }
            return depth;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
