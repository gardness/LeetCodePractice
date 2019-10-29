public class HIndexII {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int start = 0;
        int end = len - 1;

        while (start <= end) {
            int mid = (end - start) / 2 + start;

            if (citations[mid] == len - mid) {
                return len - mid;
            } else if (citations[mid] < len - mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return len - start;
    }
}
