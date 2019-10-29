import java.util.*;

public class PlusOneLinkedList {
    /**
     * 369. Plus One Linked List
     * Input:
     1->2->3

     Output:
     1->2->4

     time : O(n)
     space : O(1)
     * @param head
     * @return
     */

    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy;
        ListNode j = dummy;

        while (j.next != null) {
            j = j.next;
            if (j.val != 9) {
                i = j;
            }
        }
        i.val++;
        i = i.next;
        while (i != null) {
            i.val = 0;
            i = i.next;
        }
        if (dummy.val == 0) {
            return dummy.next;
        } else {
            return dummy;
        }
    }

    public ListNode plusOne1(ListNode head) {
        head = reverse(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        int carry = 1;
        while (carry > 0 || cur.next != null) {
            if (cur.next != null) {
                cur = cur.next;
                carry += cur.val;
                cur.val = carry % 10;
                carry /= 10;
            } else {
                cur.next = new ListNode(carry);
                cur = cur.next;
                carry = 0;
            }
        }
        return reverse(dummy.next);
    }

    public ListNode reverse(ListNode head) {
        ListNode revHead = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = revHead;
            revHead = head;
            head = tmp;
        }
        return revHead;
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
