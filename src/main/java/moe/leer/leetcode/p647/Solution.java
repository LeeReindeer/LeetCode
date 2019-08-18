package moe.leer.leetcode.p647;

/**
 * @author leer
 * @see moe.leer.leetcode.p005.Solution#longestPalindrome(String)
 * <p>
 * Created at 8/17/19 3:41 PM
 * <p>
 * 647. Palindromic Substrings
 * Medium
 * <p>
 * Given a string, your task is to count how many palindromic substrings in this string.
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 */
public class Solution {

  int count;

  public int countSubstrings(String s) {
    if (s == null || s.isEmpty()) return 0;
    for (int i = 0; i < s.length(); i++) {
      extend(s, i, i); // odd length
      extend(s, i, i + 1); // even length
    }
    return count;
  }

  private void extend(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      count++;
      left--;
      right++;
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().countSubstrings("abc"));
    System.out.println(new Solution().countSubstrings("aaa"));
  }
}
