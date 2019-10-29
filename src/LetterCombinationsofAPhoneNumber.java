import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsofAPhoneNumber {
    /**
     * time : O(3^n)
     * space : O(n)
     */

    public String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        helper(res, digits, "", 0);
        return res;
    }

    public int helper(List<String> res, String digits, String s, int index){
        if (s.length() == digits.length()) {
            res.add(s);
            return 0;
        }
        String letters = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            helper (res, digits, s + letters.charAt(i), index + 1);
        }
        return 0;
    }

    public List<String> letterCombinations1(String digits) {
        ArrayList<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int num = digits.charAt(i) - '0';
            while (res.get(0).length() == i) {
                String s = res.remove(0);
                for (int j = 0; j < mapping[num].length(); j++) {
                    res.add(s + mapping[num].charAt(j));
                }
            }
        }
        return res;
    }
}
