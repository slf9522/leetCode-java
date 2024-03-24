//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
// 
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 2272 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 排序链表
 *
 * @author JX
 * @date 2024-03-24 13:53:08
 */
public class P148_SortList {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P148_SortList().new Solution();
        System.out.println(solution.sortList(new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))))));
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
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode first = head;
            ListNode second = head;
            ListNode pre = new ListNode();
            pre.next = head;
            while (second != null && second.next != null) {
                second = second.next.next;
                pre = first;
                first = first.next;

            }
            pre.next = null;
            ListNode f = sortList(head);
            ListNode s = sortList(first);
            return merge(f, s);
        }

        public ListNode merge(ListNode f, ListNode s) {
            ListNode tmp = new ListNode();
            ListNode head = tmp;
            while (f != null && s != null) {
                int vf = f.val;
                int vs = s.val;
                if (vf < vs) {
                    tmp.next = f;
                    f = f.next;
                } else {
                    tmp.next = s;
                    s = s.next;
                }
                tmp = tmp.next;
            }
            tmp.next = f == null ? s : f;
            return head.next;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}