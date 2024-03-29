//You are given a perfect binary tree where all leaves are on the same level, 
//and every parent has two children. The binary tree has the following definition: 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
// 
//
// Populate each next pointer to point to its next right node. If there is no 
//next right node, the next pointer should be set to NULL. 
//
// Initially, all next pointers are set to NULL. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,3,4,5,6,7]
//Output: [1,#,2,3,#,4,5,6,7,#]
//Explanation: Given the above perfect binary tree (Figure A), your function 
//should populate each next pointer to point to its next right node, just like in 
//Figure B. The serialized output is in level order as connected by the next 
//pointers, with '#' signifying the end of each level.
// 
//
// Example 2: 
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
// The number of nodes in the tree is in the range [0, 2¹² - 1]. 
// -1000 <= Node.val <= 1000 
// 
//
// 
// Follow-up: 
//
// 
// You may only use constant extra space. 
// The recursive approach is fine. You may assume implicit stack space does not 
//count as extra space for this problem. 
// 
//
// Related Topics Linked List Tree Depth-First Search Breadth-First Search 
//Binary Tree 👍 9461 👎 294


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Populating Next Right Pointers in Each Node
 *
 * @author DY
 * @date 2024-02-07 21:12:06
 */
public class P116_PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P116_PopulatingNextRightPointersInEachNode().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

    class Solution {
        public Node connect(Node root) {
            if (root == null) return null;
            // 不允许空元素
            LinkedList<Node> queue = new LinkedList<>();
            queue.addLast(root);

            while (!queue.isEmpty()) {
                List<Node> level = new ArrayList<>();

                while (!queue.isEmpty()) {
                    Node n = queue.poll();
                    n.next = queue.peek(); // 没有元素的时候 peek是null
                    if (n.left != null) level.add(n.left);
                    if (n.right != null) level.add(n.right);
                }
                queue.addAll(level);
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
