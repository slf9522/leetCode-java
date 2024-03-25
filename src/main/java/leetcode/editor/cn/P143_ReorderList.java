//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
//
// Related Topics 栈 递归 链表 双指针 👍 1453 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * 重排链表
 *
 * @author JX
 * @date 2024-03-25 13:12:09
 */
public class P143_ReorderList {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P143_ReorderList().new Solution();
        solution.reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
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
        public void reorderList(ListNode head) {
            if (head.next == null) return;

            LinkedList<ListNode> list = new LinkedList<>();
            ListNode ln = head;
            int cnt = 0;
            while (ln != null) {
                list.addLast(ln);
                ln = ln.next;
                cnt++;
            }
            ListNode p = head;
            while (cnt > 0 && p != list.peekLast()) {
                ListNode poll = list.pollLast();
                ListNode tmp = p.next;
                p.next = poll;
                poll.next = tmp;
                p = tmp;
                cnt -= 2;
            }
            p.next = null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static class ListNode {
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