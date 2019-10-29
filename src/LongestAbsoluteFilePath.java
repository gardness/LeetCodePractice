import java.util.Stack;

public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        for (String str : input.split("\n+")) {
            int level = str.lastIndexOf("\t") + 1;

            while (level + 1 < stack.size()) {
                stack.pop();
            }

            int len = stack.peek() + str.length() - level + 1;

            stack.push(len);

            if (str.contains(".")) {
                res = Math.max(res, len - 1);
            }
        }

        return res;
    }
}
