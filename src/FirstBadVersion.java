public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n + 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean isBadVersion(int mid) {
        return true;
    }

}
