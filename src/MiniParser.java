import java.util.Stack;

public class MiniParser {
    public NestedInteger deserialize(String s) {
        if (!s.startsWith("[")) {
            return new NestedInteger(Integer.valueOf(s));
        }

        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger res = new NestedInteger();
        int start = 1;

        stack.push(res);

        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '[') {
                NestedInteger nestedInteger = new NestedInteger();
                stack.peek().add(nestedInteger);
                stack.push(nestedInteger);
                start = i + 1;
            } else if (ch == ',' || ch == ']') {
                if (i > start) {
                    Integer num = Integer.valueOf(s.substring(start, i));

                    stack.peek().add(new NestedInteger(num));
                }

                start = i + 1;

                if (ch == ']') {
                    stack.pop();
                }
            }

        }

        return res;
    }
}
