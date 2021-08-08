//Given the head of a linked list, remove the nth node from the end of the list 
//and return its head. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1], n = 1
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1,2], n = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is sz. 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
// Follow up: Could you do this in one pass? 
// Related Topics Linked List Two Pointers 
// 👍 6300 👎 341


package leetcode.editor.en;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        // 三种特殊情况需要判断：
        // 1、返回空，在移动end指针的时候就知道
//         2、头指针法
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode pre = new ListNode(0, head);
            ListNode end = pre;
            ListNode target = pre;
            while (n != 0 && end != null) {
                end = end.next;
                n--;
            }
            if (n > 0) {
                return null;
            }

            while (end.next != null) {
                target = target.next;
                end = end.next;
            }

            target.next = target.next.next;
            return pre.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}