import java.util.*;
import java.io.*;

public class ShortestPalindrome {
    /**
     * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it.
     * Find and return the shortest palindrome you can find by performing this transformation.

     For example:

     Given "aacecaaa", return "aaacecaaa".

     Given "abcd", return "dcbabcd".

     I agree for smaller strings charAt function may be fast. But when coming to big strings,
     I think the scenario is different. Because when I see the code for string last night
     I have found that toCharArray uses function System.arraycopy.
     We know System.arraycopy(I think it is native call) is faster.

     So when we use for loop based operations on String, we are directly moving to index for char array whereas
     we need to call the function for charAt. So for Bigger strings calling the function multiple times
     may reduce the performance of the method.

     Leetcode中代码超时：因为s.charAt()慢，把String用toCharArray 转换为字符串数组就可以。原因是toCharArray 用的是System.arraycopy 更快。我个人感觉是LC有问题，因为两者没有什么区别，面试时写视频代码没有任何问题。

     * @param s
     * @return
     */

    // time :  O(n^2) for aaaaabcaaaaa
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int i = 0;
        int j = s.length() - 1;
        int end = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                i = 0;
                end--;
                j = end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }

    public String shortestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] array = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        int end = s.length() - 1;
        while (i < j) {
            if (array[i] == array[j]) {
                i++;
                j--;
            } else {
                i = 0;
                end--;
                j = end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }
}
