package moe.leer.leetcode.p680;

/**
 * @author leer
 * Created at 1/16/20 5:06 PM
 */
public class Solution {
  public boolean validPalindrome(String s) {
    int i = 0, j = s.length() - 1;
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        // delete lo or hi to test palindrome
        return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
      }
      i++;
      j--;
    }
    return true;
  }

  public boolean isPalindrome(CharSequence s, int lo, int hi) {
    while (lo < hi) {
      if (s.charAt(lo++) != s.charAt(hi--)) return false;
    }
    return true;
  }

  public static void main(String[] args) {

  }
}
