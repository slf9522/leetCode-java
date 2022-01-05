//The thief has found himself a new place for his thievery again. There is only 
//one entrance to this area, called root. 
//
// Besides the root, each house has one and only one parent house. After a tour,
// the smart thief realized that all houses in this place form a binary tree. It w
//ill automatically contact the police if two directly-linked houses were broken i
//nto on the same night. 
//
// Given the root of the binary tree, return the maximum amount of money the thi
//ef can rob without alerting the police. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,2,3,null,3,null,1]
//Output: 7
//Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
// 
//
// Example 2: 
//
// 
//Input: root = [3,4,5,1,3,null,1]
//Output: 9
//Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 104]. 
// 0 <= Node.val <= 104 
// 
// Related Topics Dynamic Programming Tree Depth-First Search Binary Tree 
// 👍 5660 👎 88


package leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class HouseRobberIii {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIii().new Solution();
        System.out.println(solution.rob(new TreeNode(3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, null,
                new TreeNode(1)))));
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
        public int rob(TreeNode root) {
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.addLast(root);

            Map<TreeNode, Integer> rob = new HashMap<>();
            Map<TreeNode, Integer> unRob = new HashMap<>();
            rob.put(root, root.val);
            unRob.put(root, 0);

            int res = root.val;
            while (deque.size() > 0) {
                int size = deque.size();
                int subRes = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode tmp = deque.removeFirst();
                    res = Math.max(res, rob.get(tmp));
                    res = Math.max(res, unRob.get(tmp));

                    if (tmp.left != null) {
                        deque.add(tmp.left);
                        rob.put(tmp.left, unRob.get(tmp) + tmp.left.val);
                        unRob.put(tmp.left, rob.get(tmp));
                    }

                    if (tmp.right != null) {
                        deque.add(tmp.right);
                        rob.put(tmp.right, unRob.get(tmp) + tmp.right.val);
                        unRob.put(tmp.right, rob.get(tmp));
                    }

                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}