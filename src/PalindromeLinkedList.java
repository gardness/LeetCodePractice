import java.util.*;

public class PalindromeLinkedList {
    /**
     * 234. Palindrome Linked List

     * time : O(n)
     * space : O(1)
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode middle = findMiddle(head);
        middle.next = reverse(middle.next);
        ListNode i = head;
        ListNode j = middle.next;
        while (i != middle.next && j != null) {
            if (i.val != j.val) {
                return false;
            }
            i = i.next;
            j = j.next;
        }
        return true;
    }

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode revHead = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = revHead;
            revHead = cur;
            cur = tmp;
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
