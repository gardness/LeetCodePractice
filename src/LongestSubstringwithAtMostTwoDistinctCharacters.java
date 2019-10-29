import java.util.*;

public class LongestSubstringwithAtMostTwoDistinctCharacters {
    /**
     * 159. Longest Substring with At Most Two Distinct Characters
     * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

     For example, Given s = “eceba”,

     T is "ece" which its length is 3.

     sliding window

     “eceba”

     time : O(n)
     space : O(n)

     * @param s
     * @return
     */

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int res = 0;
        while (end < s.length()) {
            if (map.size() <= 2) {
                map.put(s.charAt(end), end);
                end++;
            }
            if (map.size() > 2) {
                int leftMost = s.length();
                for (int num : map.values()) {
                    leftMost = Math.min(leftMost, num);
                }
                map.remove(s.charAt(leftMost));
                start = leftMost + 1;
            }
            res = Math.max(res, end - start);
        }
        return res;
    }


    public int lengthOfLongestSubstringTwoDistinct1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] count = new int[128];
        int numDist = 0;
        int start = 0;
        int end = 0;
        int res = 0;
        while (end < s.length()) {
            if (count[s.charAt(end)]++ == 0) {
                numDist++;
            }
            while (numDist > 2) {
                if (count[s.charAt(start++)]-- == 0) {
                    numDist--;
                }
            }
            res = Math.max(res, end - start);
        }
        return res;
    }
}
