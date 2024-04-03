//给你一个整数 n ，请你找出所有可能含 n 个节点的 真二叉树 ，并以列表形式返回。答案中每棵树的每个节点都必须符合 Node.val == 0 。 
//
// 答案的每个元素都是一棵真二叉树的根节点。你可以按 任意顺序 返回最终的真二叉树列表。 
//
// 真二叉树 是一类二叉树，树中每个节点恰好有 0 或 2 个子节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 7
//输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0
//,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：[[0,0,0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 树 递归 记忆化搜索 动态规划 二叉树 👍 396 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 所有可能的真二叉树
 *
 * @author JX
 * @date 2024-04-03 09:35:50
 */
public class P894_AllPossibleFullBinaryTrees {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P894_AllPossibleFullBinaryTrees().new Solution();
        System.out.println(solution.allPossibleFBT(7));
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
        Map<Integer, List<TreeNode>> map = new HashMap<>();

        public List<TreeNode> allPossibleFBT(int n) {
            List<TreeNode> res = new ArrayList<>();
            if (n == 1) {
                TreeNode node = new TreeNode(0, null, null);
                map.put(1, Arrays.asList(node));
                return map.get(1);
            }
            if (map.containsKey(n)) return map.get(n);

            for (int i = 1; i < n; i += 2) {
                List<TreeNode> left = allPossibleFBT(i);
                List<TreeNode> right = allPossibleFBT(n - i - 1);
                for (TreeNode treeNode : left) {
                    for (TreeNode node : right) {
                        TreeNode root = new TreeNode(0, treeNode, node);
                        res.add(root);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}