public class ReverseString {

    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        int left = 0;
        int right = s.length() - 1;
        char[] str = s.toCharArray();

        while (left < right) {
            char tmp = str[left];
            str[left++] = str[right];
            str[right--] = tmp;
        }

        return new String(str);
    }

}
