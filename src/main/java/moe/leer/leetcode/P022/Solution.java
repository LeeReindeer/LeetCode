package moe.leer.leetcode.P022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author leer
 * Created at 6/17/19 8:55 PM
 */
public class Solution {
  // backtracking
  // Time: O(2^n)
  public List<String> generateParenthesis2(int n) {
    if (n <= 1) return Collections.emptyList();
    List<String> ans = new ArrayList<>(1 << n);
    backtrack(ans, "", 0, 0, n);
    return ans;
  }

  /**
   * (
   * ((
   * (((
   * ((()
   * ((())
   * ((()))
   * (()
   * (()(
   * (()()
   * (()())
   * (())
   * (())(
   * (())()
   * ()
   * ()(
   * ()((
   * ()(()
   * ()(())
   * ()()
   * ()()(
   * ()()()
   * only add "(" ans ")" when we know it will remain a valid sequence
   */
  private void backtrack(List<String> ans, String cur, int open, int close, int n) {
    if (cur.length() == 2 * n) {
      ans.add(cur);
      return;
    }
    if (open < n) {
      backtrack(ans, cur + "(", open + 1, close, n);
    }
    if (close < open) {
      backtrack(ans, cur + ")", open, close + 1, n);
    }
  }

  // brute force
  // Time: O(2^2n)
  public List<String> generateParenthesis1(int n) {
    if (n <= 1) return Collections.emptyList();
    List<String> ans = new ArrayList<>(1 << n);
    bruteForce(new char[2 * n], 0, ans);
    return ans;
  }

  /**
   * To generate all sequences(2^2n), we use a recursion.
   * All sequences of length n is just '(' plus all sequences of length n-1, and then ')'
   * plus all sequences of length n-1.
   */
  private void bruteForce(char[] curr, int pos, List<String> result) {
    if (pos == curr.length) {
      if (valid(curr)) {
        result.add(new String(curr));
      }
    } else {
      curr[pos] = '(';
      bruteForce(curr, pos + 1, result);
      curr[pos] = ')';
      bruteForce(curr, pos + 1, result);
    }
  }

  private boolean valid(char[] curr) {
    int b = 0;
    for (char c : curr) {
      if (c == '(') b++;
      else b--;
      if (b < 0) return false;
    }
    return b == 0;
  }
}
