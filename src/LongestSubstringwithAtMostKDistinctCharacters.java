public class LongestSubstringwithAtMostKDistinctCharacters {
    /**
     * 340. Longest Substring with At Most K Distinct Characters
     * Given a string, find the length of the longest substring T that contains
     * at most k distinct characters.

     For example, Given s = “eceba” and k = 2,

     T is "ece" which its length is 3.

     sliding window

     time : O(n)
     space : O(1)

     * @param s
     * @param k
     * @return
     */

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] count = new int[128];
        int res = 0;
        int num = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]++ == 0) {
                num++;
            }
            while (num > k) {
                while (--count[s.charAt(j++)] > 0);
                num--;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
