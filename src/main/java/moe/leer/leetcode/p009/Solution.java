package moe.leer.leetcode.p009;

/**
 * @author leer
 * Created at 8/18/19 10:26 PM
 */
public class Solution {
  public boolean isPalindrome(int x) {
    if (x < 0) return false;
    String s = String.valueOf(x);
    int l = 0, r = s.length() - 1;
    while (l < r) {
      if ( s.charAt(l++) != s.charAt(r--)) return false;
    }
    return true;
  }
}
