package moe.leer.leetcode.p344;

/**
 * @author leer
 * Created at 2/25/19 2:50 PM
 */
public class Solution {
  public void reverseString(char[] s) {
    if (s.length <= 1) return;
    for (int i = 0; i < s.length / 2; i++) {
      char t = s[i];
      s[i] = s[s.length - 1 - i];
      s[s.length - 1 - i] = t;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
    solution.reverseString(s);

    for (int i = 0; i < s.length; i++) {
      System.out.printf("%c ", s[i]);
    }
  }
}
