import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int idx = 0;
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();

        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;

                while (Character.isDigit(s.charAt(idx))) {
                    count = count * 10 + (s.charAt(idx) - '0');
                    idx++;
                }

                countStack.push(count);
            } else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            } else if (s.charAt(idx) == ']') {
                int time = countStack.pop();
                StringBuilder sb = new StringBuilder(resStack.pop());

                while (time != 0) {
                     sb.append(res);
                     time--;
                }

                res = sb.toString();
                idx++;
            } else {
                res += s.charAt(idx++);
            }
        }

        return res;
    }
}
