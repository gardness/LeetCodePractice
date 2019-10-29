import java.util.*;

public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
            } else {
                set.remove(c);
            }
        }
        return set.size() <= 1;
    }

    public boolean canPermutePalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int[] counts = new int[256];
        int res = 0;
        for (Character c : s.toCharArray()) {
            if (counts[c] == 0) {
                counts[c]++;
            } else {
                counts[c]--;
            }
        }
        for (int count : counts) {
            res += count;
        }

        return res <= 1;
    }
}
