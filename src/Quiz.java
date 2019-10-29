public class Quiz {

    /**
     * 1. int 存一组不重复的数字，尽量减少空间，有字母去字母
     *
     * @param str
     */

    public int quiz1(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        str = str.trim();

        int res = 0;

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {    //  感觉是如果有字母就返回 0
                return 0;
            }

            res |= 1 << (str.charAt(i) - '0');
        }

        return res;
    }

    /**
     * 2. int 存一组数字，如果遇见 0，此位不存，只存占位（判断此位有没有数字即可），有字母去字母
     *
     * @param str
     * @return
     */

    public int quiz2(String num) {
        int val = 0;
        int location = 1;

        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);

            if (!Character.isDigit(i) || ch == '0') {
                location <<= 1;
                continue;
            }

            val |= location;
            location <<= 1;
        }

        return val;
    }
}
