public class ReverseWords {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        String[] words = s.trim().split("\\s+");

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i] + " ");
        }

        return sb.toString().trim();
    }


    public String reverseWords2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] str = s.toCharArray();

        reverse(str, 0, str.length - 1);
        reverseWord(str, str.length);

        return cleanSpaces(str, str.length);
    }


    private void reverse(char[] ch, int i, int j) {
        while (i < j) {
            char tmp = ch[i];
            ch[i++] = ch[j];
            ch[j--] = tmp;
        }
    }

    private void reverseWord(char[] ch, int len) {
        int i = 0;
        int j = 0;

        while (i < len) {
            while (i < j || i < len && ch[i] == ' ') {
                i++;
            }

            while (j < i || j < len && ch[j] != ' ') {
                j++;
            }

            reverse(ch, i, j - 1);
        }
    }

    private String cleanSpaces(char[] ch, int len) {
        int i = 0;
        int j = 0;

        while (j < len) {
            while (j < len && ch[j] == ' ') {
                j++;
            }

            while (j < len && ch[j] != ' ') {
                ch[i++] = ch[j++];
            }

            while (j < len && ch[j] == ' ') {
                j++;
            }

            if (j < len) {
                ch[i++] = ' ';
            }
        }

        return String.valueOf(ch).substring(0, i);
    }
}
