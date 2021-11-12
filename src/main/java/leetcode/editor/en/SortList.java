//Given the head of a linked list, return the list after sorting it in ascending
// order. 
//
// 
// Example 1: 
//
// 
//Input: head = [4,2,1,3]
//Output: [1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: head = [-1,5,3,4,0]
//Output: [-1,0,3,4,5]
// 
//
// Example 3: 
//
// 
//Input: head = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 5 * 104]. 
// -105 <= Node.val <= 105 
// 
//
// 
// Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.
//e. constant space)? 
// Related Topics Linked List Two Pointers Divide And Conquer Sorting Merge Sort
// 
// 👍 5220 👎 193


package leetcode.editor.en;

import jdk.nashorn.internal.ir.IfNode;

public class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
        solution.sortList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null)))));
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
//    todo: 优化归并操作
    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode mid = middleNode(head);
            ListNode left = sortList(head);
            ListNode right = sortList(mid);
            return merge(left, right);
        }

        public ListNode middleNode(ListNode head) {
            if (head == null || head.next == null) return head;

            int n = 1, m = 1;
            ListNode p = head;

            while (head != null) {
                int tmp = n++ / 2;
//                while里面不能++
                while (m < tmp) {
                    p = p.next;
                    m++;
                }
                head = head.next;
            }
            ListNode res = p.next;
            p.next = null;
            return res;
        }

        public ListNode merge(ListNode left, ListNode right) {
            ListNode head = new ListNode(0, null);
            ListNode res = head;
            while (left != null || right != null) {
                if (left == null) {
                    while (right != null) {
                        head.next = right;
                        head = head.next;
                        right = right.next;
                    }
                } else if (right == null) {
                    while (left != null) {
                        head.next = left;
                        head = head.next;
                        left = left.next;
                    }
                } else {
                    if (left.val < right.val) {
                        head.next = left;
                        left = left.next;
                    } else {
                        head.next = right;
                        right = right.next;
                    }
                }
                head = head.next;
                if (head != null) head.next = null;
            }
            return res.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}