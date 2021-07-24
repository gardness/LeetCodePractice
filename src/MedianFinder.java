import java.util.Iterator;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Long> small;
    PriorityQueue<Long> large;

    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> (a.intValue() - b.intValue()));
        large = new PriorityQueue<>((a, b) -> (b.intValue() - a.intValue()));
    }

    public void addNum(int num) {
        large.offer(Long.valueOf(num));
        small.offer(large.poll());

        while (large.size() < small.size()) {
            large.offer(small.poll());
        }
    }

    public double findMedian() {
        return large.size() > small.size() ? large.peek() : (double)(large.peek() + small.peek()) / 2;
    }

}
