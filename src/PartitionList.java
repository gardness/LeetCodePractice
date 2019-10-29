import java.util.*;

public class PartitionList {
    /**
     * 86. Partition List
     * Given a linked list and a value x, partition it such that all nodes less than x come before nodes
     * greater than or equal to x.

     You should preserve the original relative order of the nodes in each of the two partitions.

     For example,
     Given 1->4->3->2->5->2 and x = 3,
     return 1->2->2->4->3->5.


     1->4->3->2->5->2 and x = 3
     smallHead -> 1 -> 2 -> 2 ->
     small
     bigHead -> 4 -> 3 -> 5 ->
     big

     time : O(n)
     space : O(n)


     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode smallHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode bigHead = new ListNode(0);
        ListNode big = bigHead;
        while (head != null) {
            ListNode tmp = new ListNode(head.val);
            if (tmp.val < x) {
                small.next = tmp;
                small = small.next;
            } else {
                big.next = tmp;
                big = big.next;
            }
            head = head.next;
        }
        small.next = bigHead.next;

        return smallHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
