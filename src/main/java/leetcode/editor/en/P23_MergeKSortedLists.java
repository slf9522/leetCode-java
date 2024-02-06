//You are given an array of k linked-lists lists, each linked-list is sorted in 
//ascending order. 
//
// Merge all the linked-lists into one sorted linked-list and return it. 
//
// 
// Example 1: 
//
// 
//Input: lists = [[1,4,5],[1,3,4],[2,6]]
//Output: [1,1,2,3,4,4,5,6]
//Explanation: The linked-lists are:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//merging them into one sorted list:
//1->1->2->3->4->4->5->6
// 
//
// Example 2: 
//
// 
//Input: lists = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: lists = [[]]
//Output: []
// 
//
// 
// Constraints: 
//
// 
// k == lists.length 
// 0 <= k <= 10⁴ 
// 0 <= lists[i].length <= 500 
// -10⁴ <= lists[i][j] <= 10⁴ 
// lists[i] is sorted in ascending order. 
// The sum of lists[i].length will not exceed 10⁴. 
// 
//
// Related Topics Linked List Divide and Conquer Heap (Priority Queue) Merge 
//Sort 👍 18932 👎 687


package leetcode.editor.en;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Merge k Sorted Lists
 *
 * @author DY
 * @date 2024-02-04 17:10:04
 */
public class P23_MergeKSortedLists {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P23_MergeKSortedLists().new Solution();
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
        public ListNode mergeKLists(ListNode[] lists) {
            int k = lists.length;
            if(k == 0) return null;
            if(k == 1) return lists[0];

            //         if (initialCapacity < 1)
            //            throw new IllegalArgumentException();
            PriorityQueue<ListNode> pq = new PriorityQueue<>(k, Comparator.comparingInt(a -> a.val));
            ListNode dummy = new ListNode(), head = dummy;

            for (int i = 0; i < k; i++) {
                if (lists[i]!=null) pq.add(lists[i]);
            }
            while(pq.size() !=0 ){
                ListNode p = pq.poll();
                if(p.next!=null) pq.add(p.next);
                head.next = p;
                head = head.next;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
