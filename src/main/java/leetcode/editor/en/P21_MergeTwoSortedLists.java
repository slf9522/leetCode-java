//You are given the heads of two sorted linked lists list1 and list2. 
//
// Merge the two lists into one sorted list. The list should be made by 
//splicing together the nodes of the first two lists. 
//
// Return the head of the merged linked list. 
//
// 
// Example 1: 
// 
// 
//Input: list1 = [1,2,4], list2 = [1,3,4]
//Output: [1,1,2,3,4,4]
// 
//
// Example 2: 
//
// 
//Input: list1 = [], list2 = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: list1 = [], list2 = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in both lists is in the range [0, 50]. 
// -100 <= Node.val <= 100 
// Both list1 and list2 are sorted in non-decreasing order. 
// 
//
// Related Topics Linked List Recursion 👍 21011 👎 1997


package leetcode.editor.en;

/**
 * Merge Two Sorted Lists
 *
 * @author DY
 * @date 2024-02-04 17:04:47
 */
public class P21_MergeTwoSortedLists {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P21_MergeTwoSortedLists().new Solution();
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        	ListNode dummy = new ListNode();
            ListNode p =dummy;
            ListNode p1 = list1, p2= list2;

            while(p1!=null || p2!=null) {
                if(p1 == null) {
                    p.next = p2;
                    p2 = p2.next;
                } else if( p2 == null) {
                    p.next = p1;
                    p1 = p1.next;
                } else {
                    if(p1.val > p2.val) {
                        p.next = p2;
                        p2 = p2.next;
                    } else {
                        p.next = p1;
                        p1 = p1.next;
                    }
                }
                p = p.next;
            }

            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
