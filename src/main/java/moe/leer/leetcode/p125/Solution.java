package moe.leer.leetcode.p125;

/**
 * @author leer
 * Created at 5/4/19 2:15 PM
 * <p>
 * O(N/2)
 */
public class Solution {
  public boolean isPalindrome(String s) {
    if (s.isEmpty()) return true;
    int head = 0, tail = s.length() - 1;
    char c1, c2;
    while (head <= tail) {
      c1 = s.charAt(head);
      c2 = s.charAt(tail);
      if (!Character.isLetterOrDigit(c1)) {
        head++;
      } else if (!Character.isLetterOrDigit(c2)) {
        tail--;
      } else {
        if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) return false;
        head++;
        tail--;
      }
    }
    return true;
  }
}
