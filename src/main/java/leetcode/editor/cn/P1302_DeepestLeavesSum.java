//给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
//输出：15
// 
//
// 示例 2： 
//
// 
//输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//输出：19
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 10⁴] 之间。 
// 1 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 172 👎 0


package leetcode.editor.cn;


import java.util.LinkedList;

/**
 * 层数最深叶子节点的和
 *
 * @author JX
 * @date 2024-03-17 08:30:52
 */
public class P1302_DeepestLeavesSum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1302_DeepestLeavesSum().new Solution();
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
        public int deepestLeavesSum(TreeNode root) {
            LinkedList<TreeNode> list = new LinkedList<>();
            list.addLast(root);
            int pre = 0;
            while (!list.isEmpty()) {
                pre = 0;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    TreeNode tn = list.pollFirst();
                    pre += tn.val;
                    if (tn.left != null) list.addLast(tn.left);
                    if (tn.right != null) list.addLast(tn.right);
                }
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}