//Given the root of a binary tree, return the sum of values of its deepest 
//leaves.
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
//Output: 15
// 
//
// Example 2: 
//
// 
//Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//Output: 19
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// 1 <= Node.val <= 100 
// 
//
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 46
//22 👎 121


package leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Deepest Leaves Sum
 *
 * @author JX
 * @date 2024-02-19 18:56:00
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
			Queue<TreeNode> queue = new LinkedList<>();

			int res = 0;
			queue.offer(root);
			while(queue.size()!=0) {
				res = 0;
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					TreeNode t = queue.poll();
					if(t.left!=null) queue.offer(t.left);
					if(t.right!=null) queue.offer(t.right);
					res += t.val;
				}
			}
			return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
