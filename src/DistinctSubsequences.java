public class DistinctSubsequences {
    /**
     * 115. Distinct Subsequences
     * Given a string S and a string T, count the number of distinct subsequences of S which equals T.

     A subsequence of a string is a new string which is formed from the original string
     by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.
     (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

     Here is an example:
     S = "rabbbit", T = "rabbit"

     Return 3.

     int[][] dp

     Recurrence relation :

     1, S.charAt(i) != T.charAt(j)
     dp[i][j] = dp[i-1][j]

     2, S.charAt(i) == T.charAt(j)
     dp[i][j] = dp[i-1][j] + dp[i-1][j-1]

     S -> T                             //  dp[i][j] = k means the first i-length substring in S contains k distinct subsequences which equals the first j-length substring in T

          r  a  b  b  i  t              //  rows for S, columns for T, dp[0][] & dp[][0] for empty string ""
       1, 0, 0, 0, 0, 0, 0
     r 1, 1, 0, 0, 0, 0, 0
     a 1, 1, 1, 0, 0, 0, 0
     b 1, 1, 1, 1, 0, 0, 0
     b 1, 1, 1, 2, 1, 0, 0
     b 1, 1, 1, 3, 3, 0, 0
     i 1, 1, 1, 3, 3, 3, 0
     t 1, 1, 1, 3, 3, 3, 3


     // 如果对 DP 不是很熟悉，可以先把矩阵全部写出来，然后再找规律


     time : O(m * n)
     space : O(m * n)


     * @param s
     * @param t
     * @return
     */

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
