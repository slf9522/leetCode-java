//Given the head of a singly linked list and two integers left and right where l
//eft <= right, reverse the nodes of the list from position left to position right
//, and return the reversed list. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], left = 2, right = 4
//Output: [1,4,3,2,5]
// 
//
// Example 2: 
//
// 
//Input: head = [5], left = 1, right = 1
//Output: [5]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is n. 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//Follow up: Could you do it in one pass? Related Topics Linked List 
// 👍 5092 👎 245


package leetcode.editor.en;

public class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            // 哨兵，防止left==1
            ListNode pre = new ListNode(0, head);

            int cnt = 0;
            ListNode h = pre;
            // 找到left前一个元素
            while (cnt < left - 1) {
                h = h.next;
                cnt++;
            }
            ListNode l = h;
            // 找到尾巴
            while (cnt < right) {
                h = h.next;
                cnt++;
            }

            l.next = reverseList(l.next, h.next);
            return pre.next;
        }

        // 透传尾巴，作为终止判断
        public ListNode reverseList(ListNode head, ListNode stop) {
            if (head.next == stop) return head;
            ListNode res = reverseList(head.next, stop);
            head.next.next = head;
            head.next = stop;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}