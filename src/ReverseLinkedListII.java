import java.util.*;

public class ReverseLinkedListII {
    /**
     * 92. Reverse Linked List II
     * For example:
     Given 1->2->3->4->5->NULL, m = 2 and n = 4,

     return 1->4->3->2->5->NULL.

     1->2->3->4->5
     p  c  t


     time : O(n);
     space : O(1);

     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);

        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = dummy.next;

        for (int i = 1; i < m; ++i) {
            cur = cur.next;
            pre = pre.next;
        }

        for (int i = 0; i < n - m; ++i) {
            ListNode tmp = cur.next;

            cur.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }

        return dummy.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
