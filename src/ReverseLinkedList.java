import java.util.*;

public class ReverseLinkedList {
    /**
     * 206. Reverse Linked List

     time : O(n);
     space : O(1);

     * @param head
     * @return
     */

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
}
