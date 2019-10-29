public class GuessNumberHigherOrLower {

    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;

            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (guess(left) == 0) {
            return left;
        } else {
            return right;
        }
    }

    public int guess(int n) {
        return 0;
    }

}
