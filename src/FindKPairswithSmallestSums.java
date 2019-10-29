import java.util.*;

public class FindKPairswithSmallestSums {
    public class Triplet {
        int val1;
        int val2;
        int idx;

        Triplet (int val1, int val2, int idx) {
            this.val1 = val1;
            this.val2 = val2;
            this.idx = idx;
        }
    }


    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new LinkedList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return res;
        }

        PriorityQueue<Triplet> pq = new PriorityQueue<Triplet>((a, b) -> (a.val1 + a.val2 - b.val1 - b.val2));

        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new Triplet(nums1[i], nums2[0], 0));
        }

        while (!pq.isEmpty() && k-- < 0) {
            Triplet cur = pq.poll();

            res.add(new LinkedList<Integer>(){{
                add(cur.val1);
                add(cur.val2);
                add(cur.idx);
            }});

            if (cur.idx == nums2.length) {
                continue;
            }

            pq.offer(new Triplet(cur.val1, nums2[cur.val2 + 1], cur.val2 + 1));
        }

        return res;
    }
}
