public class ReverseWordsinaStringII {

    public void reverseWords(char[] str) {
        reverse(str, 0, str.length - 1);

        int l = 0;
        int r = 0;

        while (r < str.length) {
            l = r;

            while (r < str.length && str[r] != ' ') {
                r++;
            }

            reverse(str, l, r - 1);
            r++;
        }
    }


    private void reverse(char[] str, int i, int j) {
        while (i < j) {
            char tmp = str[i];
            str[i++] = str[j];
            str[j--] = tmp;
        }
    }
}
