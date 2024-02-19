//Given a binary tree, find its minimum depth. 
//
// The minimum depth is the number of nodes along the shortest path from the 
//root node down to the nearest leaf node. 
//
// Note: A leaf is a node with no children. 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: root = [2,null,3,null,4,null,5,null,6]
//Output: 5
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 10⁵]. 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 71
//31 👎 1287


package leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Minimum Depth of Binary Tree
 * @author JX
 * @date 2024-02-17 08:08:34
 */
public class P111_MinimumDepthOfBinaryTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P111_MinimumDepthOfBinaryTree().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth2(TreeNode root) {
        if(root == null) return 0;
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		int res =0;
		if (left == 0){
			return right + 1;
		} else if(right == 0){
			return left  + 1;
		} else {
			return Math.min(left, right) + 1;
		}
    }

	public int minDepth(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null) return 0;

		queue.offer(root);
		int size = 1;
		while(queue.size() != 0){
			int s = queue.size();
			for (int i = 0; i < s; i++) {
				TreeNode node = queue.poll();
				if(root.left == null && root.right ==null) {
					return size;
				}
				if(root.left!=null) queue.offer(node.left);
				if(root.right!=null) queue.offer(node.right);
			}
			size++;
		}
		return size;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
