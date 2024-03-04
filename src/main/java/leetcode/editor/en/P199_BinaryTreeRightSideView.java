//Given the root of a binary tree, imagine yourself standing on the right side 
//of it, return the values of the nodes you can see ordered from top to bottom. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,3,null,5,null,4]
//Output: [1,3,4]
// 
//
// Example 2: 
//
// 
//Input: root = [1,null,3]
//Output: [1,3]
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 11
//664 👎 879


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Binary Tree Right Side View
 *
 * @author JX
 * @date 2024-03-04 10:48:54
 */
public class P199_BinaryTreeRightSideView {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P199_BinaryTreeRightSideView().new Solution();
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
        public List<Integer> rightSideView(TreeNode root) {
			if(root == null) {
				return new ArrayList<>();
			}

			List<Integer> res = new ArrayList<>();

			Deque<TreeNode> dq = new LinkedList<>();
			dq.offerLast(root);

			while(dq.size()!=0) {
				int size = dq.size();
				for (int i = 0; i < size; i++) {
					TreeNode node = dq.pollFirst();
					if (i == size - 1){
						res.add(node.val);
					}
					if(node.left != null) dq.addLast(node.left);
					if(node.right != null) dq.addLast(node.right);
				}
			}
			return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
