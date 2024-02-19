//Given the root of a binary search tree, and an integer k, return the kᵗʰ 
//smallest value (1-indexed) of all the values of the nodes in the tree. 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,1,4,null,2], k = 1
//Output: 1
// 
//
// Example 2: 
// 
// 
//Input: root = [5,3,6,2,4,null,null,1], k = 3
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is n. 
// 1 <= k <= n <= 10⁴ 
// 0 <= Node.val <= 10⁴ 
// 
//
// 
// Follow up: If the BST is modified often (i.e., we can do insert and delete 
//operations) and you need to find the kth smallest frequently, how would you 
//optimize? 
//
// Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 👍 1110
//2 👎 218


package leetcode.editor.en;

/**
 * Kth Smallest Element in a BST
 *
 * @author DY
 * @date 2024-02-09 14:55:26
 */
public class P230_KthSmallestElementInABst {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P230_KthSmallestElementInABst().new Solution();
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

		int rank  = 0;
		int res;
        public int kthSmallest(TreeNode root, int k) {
			transverse(root, k);
			return res;
        }

		private void transverse(TreeNode root, int k) {
			if(root == null) return;

			transverse(root.left, k);
			rank++;
			if(rank == k) {
				res = root.val;
				return;
			}
			transverse(root.right, k);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
