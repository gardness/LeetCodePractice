import java.util.*;

public class CopyListwithRandomPointer {
    /**
     * 138. Copy List with Random Pointer
     * A linked list is given such that each node contains an additional random pointer which could
     * point to any node in the list or null.

     Return a deep copy of the list

     time : O(n);
     space : O(n);
     * @param head
     * @return
     */

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val, null, null));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        while (cur != null) {
            Node tmp = new Node(cur.val, null, null);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        cur = head;
        Node dummy = new Node(0, null, null);
        Node next;
        Node copyNext;
        Node copycur = dummy;
        while (cur != null) {
            next = cur.next.next;
            copyNext = cur.next;
            copycur.next = copyNext;
            copycur = copyNext;
            cur.next = next;
            cur = next;
        }
        return dummy.next;
    }
}
