//Given the head of a sorted linked list, delete all nodes that have duplicate 
//numbers, leaving only distinct numbers from the original list. Return the linked 
//list sorted as well. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,3,3,4,4,5]
//Output: [1,2,5]
// 
//
// Example 2: 
// 
// 
//Input: head = [1,1,1,2,3]
//Output: [2,3]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 300]. 
// -100 <= Node.val <= 100 
// The list is guaranteed to be sorted in ascending order. 
// 
//
// Related Topics Linked List Two Pointers 👍 8603 👎 229


package leetcode.editor.en;

/**
 * Remove Duplicates from Sorted List II
 *
 * @author JX
 * @date 2024-02-28 13:11:10
 */
public class P82_RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P82_RemoveDuplicatesFromSortedListIi().new Solution();
    }

//力扣代码
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
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null) return null;
            ListNode pre = new ListNode();
            pre.next = head;

            ListNode tmp = pre;
            ListNode p = head;
            ListNode next = head.next;

            while (next != null) {
                if (p.val == next.val) {
                    while (next != null && p.val == next.val) {
                        next = next.next;
                    }
                    // tmp -> p -> next
                    if (next == null) {
                        tmp.next = null;
                        break;
                    } else {
                        tmp.next = next;
                        p = next;
                        next = next.next;
                    }
                } else {
                    tmp = p;
                    p = next;
                    next = next.next;
                }
            }
            return pre.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
