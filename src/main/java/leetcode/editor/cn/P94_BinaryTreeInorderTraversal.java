//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 2048 👎 0


package leetcode.editor.cn;

import leetcode.editor.en.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 *
 * @author JX
 * @date 2024-03-11 14:53:52
 */
public class P94_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P94_BinaryTreeInorderTraversal().new Solution();
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
        /**
         * def f_iter(n):
         * stack = []
         * # 入参，接收递归调用的(a,b), flag
         * base_frame = [None, {'a': None, 'b': None}, 0]
         * first_frame = [(n, 'a'), {}, 0]
         * stack.append(base_frame)
         * stack.append(first_frame)
         * while len(stack) > 1:
         * arg, local, flag = stack[-1]
         * arg, aorb = arg
         * if flag == 0:
         * pass
         * elif flag == 1:
         * pass
         * elif flag == 2:
         * pass
         * return stack[0][-2]['a']
         *
         * @param root
         * @return
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();

            Stack<Node> stack = new Stack<>();
            stack.push(new Node(null, -1));
            stack.push(new Node(root, 1));

            while (stack.size() != 0) {
                Node node = stack.pop();
                
            }
            return res;
        }


    }

    class Node {

        public Node(TreeNode root, int i) {
            this.node = node;
            this.status = status;
        }

        TreeNode node;
        int status;
    }
//leetcode submit region end(Prohibit modification and deletion)

}