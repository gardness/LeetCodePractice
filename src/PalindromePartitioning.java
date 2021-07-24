import java.util.*;

public class PalindromePartitioning {
    /**
     * 131. Palindrome Partitioning
     * Given a string s, partition s such that every substring of the partition is a palindrome.

     Return all possible palindrome partitioning of s.

     For example, given s = "aab",
     Return

     [
     ["aa","b"],
     ["a","a","b"]
     ]

     This is a recursion version of backtracking, compared to the iteration version of backtracking in notes of CSCI6221. Can you see the pros and cons between these two?

     s    :  aab
     list :  aa b
     res  :  a a b
     aa b

     time: O(2^n)           //  We have to divide the string in every traversal we make.
     space: O(n)

     * @param s
     * @return
     */


    // List version :

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        helper(res, new ArrayList<>(), s);
        return res;
    }

    private void helper(List<List<String>> res, List<String> list, String s) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.substring(0, i + 1))) {
                list.add(s.substring(0, i + 1));
                helper(res, list, s.substring(i + 1));
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }


    /*

    Stack version :

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        DFS(res, new Stack<>(), s);
        return res;
    }

    private void DFS(List<List<String>> res, Stack<String> stack, String s) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(stack));                            //  How convenient is that?
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.substring(0, i + 1))) {
                stack.push(s.substring(0, i + 1));
                DFS(res, stack, s.substring(i + 1));
                stack.pop();
            }
        }
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    */

    /*

    iteration version of Backtracking :  感觉可能是思路是对的，但思考的角度有问题。可能还是没有领会到 Backtracking 的精髓，出现了太多复杂的情况

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }

        int depth = 0;
        int dist = 1;
        int ret = -2;
        Stack<String> stack = new Stack<>();

        while (depth > -1 && dist < s.length() + 1) {
            ret = getnext(stack, s, depth, dist);
            if (ret == -1) {
                depth--;
            } else if ((ret != -1 && ret != -2) && (ret + dist < s.length() + 1)) {                              //  depth changes more than 1 step and dist hasn't changed yet.
                depth = ret++;
            } else if ((ret != -1 && ret != -2) || depth == s.length() - 1) {
                res.add(new ArrayList<>(stack));
            } else if (ret != -2 && depth == 0) {                //  when depth == 0 except the time we first started
                depth++;
                dist++;
            } else {
                depth++;
            }
        }
        return res;
    }

    private int getnext(Stack<String> stack, String s, int depth, int dist) {
        while (depth + dist < s.length() + 1) {
            if (isPalindrome(s.substring(depth, depth + dist))) {
                stack.add(s.substring(depth, depth + dist));
                return depth;
            }
            depth++;
        }
        return -1;
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
    */
}
