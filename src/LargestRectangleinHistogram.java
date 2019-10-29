import java.util.Stack;

public class LargestRectangleinHistogram {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < heights.length + 1; i++) {
            int h = i == heights.length ? 0 : heights[i];

            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int start = stack.isEmpty() ? -1 : stack.peek();
                int area = height * (i - 1 - start);

                res = Math.max(res, area);
            }

            stack.push(i);
        }

        return res;
    }
}
