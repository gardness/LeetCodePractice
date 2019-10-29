public class ReverseVowelsofaString {

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String vowels = "aeiouAEIOU";
        char[] array = s.toCharArray();

        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            while (l < r && vowels.indexOf(array[l]) == -1) {
                l++;
            }

            while (l < r && vowels.indexOf(array[r]) == -1) {
                r--;
            }

            char tmp = array[l];
            array[l++] = array[r];
            array[r--] = tmp;
        }

        return String.valueOf(array);
    }
}
