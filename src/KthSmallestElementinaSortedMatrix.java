import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix {
    class Tuple {
        int x, y, val;

        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (int i = 0; i < matrix.length; i++) {
            pq.offer(new Tuple(0, i, matrix[0][i]));
        }

        for (int i = 0; i < k - 1; i++) {
            Tuple tuple = pq.poll();

            if (tuple.x == matrix.length - 1) {
                continue;
            }

            pq.offer(new Tuple(tuple.x + 1, tuple.y, matrix[tuple.x + 1][tuple.y]));
        }

        return pq.poll().val;
    }

    public int kthSmallest1(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (a - b));

        for (int i = 0 ; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                pq.offer(matrix[i][j]);

                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        return pq.peek();
    }

    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];

        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            int num = count(matrix, mid);

            if (num >= k) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (count(matrix, right) <= k - 1) {
            return right;
        }

        return left;
    }

//    private int count(int[][] matrix, int target) {                     //  Count the number of elements that are smaller than target
//        int n = matrix.length;
//        int res = 0;
//        int i = n - 1;
//        int j = 0;
//
//        while (i >= 0 && j < n) {
//            if (matrix[i][j] < target) {
//                res += i + 1;
//                j++;
//            } else {
//                i--;
//            }
//        }
//
//        return res;
//    }

    public int kthSmallest3(int[][] matrix, int k) {
        int left = matrix[0][0];
        int right = matrix[matrix.length - 1][matrix.length - 1];

        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;

            if (count(matrix, mid) >= k) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (count(matrix, left) == k - 1) {
            return left;
        } else {
            return right;
        }
    }

    public int count(int[][] matrix, int target) {
        int res = 0;
        int i = matrix.length - 1;
        int j = 0;

        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] < target) {
                res += i + 1;
                j++;
            } else {
                i--;
            }
        }

        return res;
    }
}
