import java.util.*;

public class GenerateParentheses {
    /**
     * 22. Generate Parentheses
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

     For example, given n = 3, a solution set is:
     [
     "((()))",
     "(()())",
     "(())()",
     "()(())",
     "()()()"
     ]


     time : O(n!) (2^n)
     space : O(n)

     卡特兰数：
     (0,n-1) (1,n-2) (2,n-3) ... (n-1,0)

     * @param n
     * @return
     */

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        helper(res,"", n, n);
        return res;
    }

    private static int helper(List<String> res, String s, int left, int right) {
        if (left < right) {
            return -1;
        }
        if (right == 0 && left == 0) {
            res.add(s);
            return 0;
        }
        if (left > 0) {
            helper(res, s + "(", left - 1, right);
        }
        if (right > 0) {
            helper(res, s + ")", left, right + 1);
        }
        return 0;
    }
}
