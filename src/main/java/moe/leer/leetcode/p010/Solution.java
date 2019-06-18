package moe.leer.leetcode.p010;

/**
 * @author leer
 * Created at 6/18/19 8:10 PM
 * <p>
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 */
public class Solution {
  // recursion
  public boolean isMatch(String s, String p) {
    if (p.isEmpty()) return s.isEmpty();
    boolean firstMatch = (!s.isEmpty()
        && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
    // there is a star after current char
    // we can skip it or repeat it
    if (p.length() >= 2 && p.charAt(1) == '*') {
      return isMatch(s, p.substring(2)) // skip
          || (firstMatch && isMatch(s.substring(1), p)); // repeat
    } else {
      // no star
      return firstMatch && isMatch(s.substring(1), p.substring(1));
    }
  }

  private Boolean[][] memo;

  // top-down dp
  // memo[i][j] presents whether s.subString(i) match p.subString(j)
  // Time: O(s.length * p.length)
  public boolean isMatchDP(String s, String p) {
    memo = new Boolean[s.length() + 1][p.length() + 1];
    return dp(0, 0, s, p);
  }

  private boolean dp(int i, int j, String s, String p) {
    if (memo[i][j] != null) return memo[i][j];
    boolean ans;
    if (j == p.length()) {
      ans = i == s.length();
    } else {
      boolean firstMatch = (i < s.length()
          && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));
      if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
        ans = dp(i, j + 2, s, p) // skip *
            || firstMatch && dp(i + 1, j, s, p); // repeat
      } else {
        ans = firstMatch && dp(i + 1, j + 1, s, p);
      }
    }
    memo[i][j] = ans;
    return ans;
  }
}
