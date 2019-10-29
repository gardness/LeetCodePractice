public class StringtoInteger {
    public int myAtoi(String str) {
        str = str.trim();

        if (str == null || str.length() == 0) {
            return 0;
        }

        int sign = 1;
        long res = 0;
        int start = 0;

        if (str.charAt(0) == '+') {
            sign = 1;
            start++;
        } else if (str.charAt(0) == '-') {
            sign = -1;
            start++;
        }

        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) res * sign;
            }

            res = res * 10 + str.charAt(i) - '0';

            if (sign == 1 && res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (sign == -1 && res > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int) res * sign;
    }
}
