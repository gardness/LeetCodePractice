import java.util.*;

public class PalindromePermutationII {
    /**
     * 267. Palindrome Permutation II
     * Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.

     For example:

     Given s = "aabb", return ["abba", "baab"].

     Given s = "abc", return [].

     time : 不知道
     space : O(n)

     * @param s
     * @return
     */

    public List<String> generatePalindromes(String s) {
        if (s == null || s.length() == 0) {
            return Arrays.asList(s);
        }

        int odd = 0;
        String mid = "";
        List<String> res = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            odd += map.get(s.charAt(i)) % 2 != 0 ? 1 : -1;
        }
        if (odd > 1) {
            return res;
        }

        for (HashMap.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (val % 2 != 0) {
                mid += key;
            }
            for (int i = 0; i < val / 2; i++) {
                list.add(key);
            }
        }

        helper(list, mid, new boolean[list.size()], new StringBuilder(), res);

        return res;
    }

    private int helper(List<Character> list, String mid, boolean[] used, StringBuilder sb, List<String> res) {
        if (sb.length() == list.size()) {
            res.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
            return 0;
        }

        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                sb.append(list.get(i));
                helper(list, mid, used, sb, res);
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        return 0;
    }
}
