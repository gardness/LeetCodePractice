import java.util.*;

public class RotateList {
    /**
     * 61. Rotate List
     * For example:
     Given 1->2->3->4->5->NULL and k = 2,
     return 4->5->1->2->3->NULL.

     time : O(n);
     space : O(1);

     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        int len = 0;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }
        cur.next = head;
        for (int i = 0; i < len - k % len - 1; i++) {
            head = head.next;
        }
        ListNode res = head.next;
        head.next = null;
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
