import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/+");

        for (String name : paths) {
            if (name.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!name.equals(".") && !name.equals("")) {
                stack.push(name);
            }
        }

        String res = "";

        while (!stack.isEmpty()) {
            res = '/' + stack.pop() + res;
        }

        if (res.length() == 0) {
            res = "/";
        }

        return res;
    }
}
