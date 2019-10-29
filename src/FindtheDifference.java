package leetcode;

public class FindtheDifference {
    /**
     * time : O(n);
     * space : O(1);
     * @param s
     * @param t
     * @return
     */
    public char findtheDifference(String s, String t) {
        char ch = t.charAt(t.length() - 1);

        for(int i = 0; i < s.length(); i++) {
            ch ^= s.charAt(i);
            ch ^= t.charAt(i);
        }

        return ch;
    }
}
