import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int res = 0;
        int end = 0;

        for (int i = 0; i < intervals.length; i++) {
            if (starts[i] < ends[end]) {
                res++;
            } else {
                end++;
            }
        }

        return res;
    }

    public int minMeetingRooms2(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> res = new PriorityQueue<>(intervals.length, (a, b) -> a[1] - b[1]);

        res.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] tmp = res.poll();
            if (intervals[i][0] >= tmp[1]) {
                tmp[1] = intervals[i][1];
            } else {
                res.offer(intervals[i]);
            }
            res.offer(tmp);
        }

        return res.size();
    }
}
