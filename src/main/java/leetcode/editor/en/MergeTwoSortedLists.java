//Merge two sorted linked lists and return it as a sorted list. The list should 
//be made by splicing together the nodes of the first two lists. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [1,2,4], l2 = [1,3,4]
//Output: [1,1,2,3,4,4]
// 
//
// Example 2: 
//
// 
//Input: l1 = [], l2 = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: l1 = [], l2 = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in both lists is in the range [0, 50]. 
// -100 <= Node.val <= 100 
// Both l1 and l2 are sorted in non-decreasing order. 
// 
// Related Topics Linked List Recursion 
// 👍 8938 👎 889


package leetcode.editor.en;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        solution.mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))), new ListNode(1, new ListNode(3,
                new ListNode(4))));
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode();
            ListNode res = head;
            while (l1 != null || l2 != null) {
                if (l1 == null) {
                    while (l2 != null) {
                        head.next = l2;
                        head = head.next;
                        l2 = l2.next;
                    }
                } else if (l2 == null) {
                    while (l1 != null) {
                        head.next = l1;
                        head = head.next;
                        l1 = l1.next;
                    }
                } else {
                    if (l1.val < l2.val) {
                        head.next = l1;
                        head = head.next;
                        l1 = l1.next;
                    } else {
                        head.next = l2;
                        head = head.next;
                        l2 = l2.next;
                    }
                }
            }
            return res.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}