import java.util.Arrays;

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 1) {
            return true;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int i = 0; i + 1 < intervals.length; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }

        return true;
    }
}