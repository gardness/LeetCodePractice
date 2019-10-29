import java.util.*;

public class LinkedListRandomNode {
    /**
     * 382. Linked List Random Node
     *
     * time : O(n);
     * @param head
     */

    public class ListNode {
        int val;
        ListNode next;
    }

    private ListNode head;
    Random rand;

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        rand = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode tmp = head;
        int res = -1;
        int i = 0;

        while (tmp != null) {
            if (rand.nextInt(++i) == 0) {
                res = tmp.val;
            }
            tmp = tmp.next;
        }

        return res;
    }
}
