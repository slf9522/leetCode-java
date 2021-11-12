//Given the head of a singly linked list, return true if it is a palindrome. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,2,1]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: head = [1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 105]. 
// 0 <= Node.val <= 9 
// 
//
// 
//Follow up: Could you do it in O(n) time and O(1) space? Related Topics Linked 
//List Two Pointers Stack Recursion 
// 👍 6925 👎 486


package leetcode.editor.en;

public class PalindromeLinkedList {
    public static void main(String[] args) {

        Solution solution = new PalindromeLinkedList().new Solution();
        System.out.println(solution.isPalindrome(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(1))))));
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
        public boolean isPalindrome(ListNode head) {
            ListNode h = head;
            int l = 0;
            while (h != null) {
                h = h.next;
                l++;
            }
            return isPalindrome(head, l) != null;
        }

        private ListNode isPalindrome(ListNode n, int cnt) {
            if (n == null) return null;

            if (cnt == 1) return n;
            if (cnt == 2) {
                if (n.val == n.next.val) {
                    return n.next;
                } else {
                    return null;
                }
            }

            ListNode last = isPalindrome(n.next, cnt - 2);
            if (last != null && n.val == last.next.val) {
                return last.next;
            } else {
                return null;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}