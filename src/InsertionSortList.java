import java.util.*;

public class InsertionSortList {
    /**
     * 147. Insertion Sort List
     * time : O(n^2)
     * space : O(1)
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode tmp = null;
        ListNode prev = dummy;
        while (cur != null && cur.next != null) {
            if (cur.val <= cur.next.val) {
                cur = cur.next;
            } else {
                tmp = cur.next;
                cur.next = tmp.next;
                prev = dummy;
                while (prev.next.val <= tmp.val) {
                    prev = prev.next;
                }
                tmp.next = prev.next;
                prev.next = tmp;
            }
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
