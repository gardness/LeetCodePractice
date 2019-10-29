public class PalindromeNumber {

    /**
     time : O(logn) space : O(1)
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || x != 0 && x % 10 == 0) {
            return false;
        }
        int res = 0;
        int tmp = x;
        while (tmp > 0) {
            res = res * 10 + tmp % 10;
            tmp /= 10;
        }
        return res == x;
    }
}
