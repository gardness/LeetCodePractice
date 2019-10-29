public class LongestSubstringwithAtLeastKRepeatingCharacters {
    public class _395_LongestSubstringwithAtLeastKRepeatingCharacters {
        /**
         * 395. Longest Substring with At Least K Repeating Characters
         * Find the length of the longest substring T of a given string (consists of lowercase letters only)
         * such that every character in T appears no less than k times.

         Example 1:

         Input:
         s = "aaabb", k = 3

         Output:
         3

         The longest substring is "aaa", as 'a' is repeated 3 times.
         Example 2:

         Input:
         s = "ababbc", k = 2

         Output:
         5

         The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.


         * @param s
         * @param k
         * @return
         */

        // time : O(n) space : O(1)
        public int longestSubstring(String s, int k) {
            int res = 0;
            for (int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++) {
                res = Math.max(res, helper(s, k, numUniqueTarget));
            }
            return res;
        }

        private int helper(String s, int k, int numUniqueTarget) {
            int[] count = new int[128];
            int numUnique = 0;
            int noLessThanK = 0;
            int start = 0;
            int end = 0;
            int res = 0;
            while (end < s.length()) {
                if (count[s.charAt(end)]++ == 0) {
                    numUnique++;
                }
                if (count[s.charAt(end++)] == k) {
                    noLessThanK++;
                }
                while (numUnique > numUniqueTarget) {
                    if (count[s.charAt(start)]-- == k) {
                        noLessThanK--;
                    }
                    if (count[s.charAt(start++)] == 0) {
                        numUnique--;
                    }
                }
                if (numUnique == numUniqueTarget && numUnique == noLessThanK) {
                    res = Math.max(end - start, res);
                }
            }
            return res;
        }
    }
}
