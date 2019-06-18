package moe.leer.leetcode.p010;


import static org.junit.Assert.*;

/**
 * @author leer
 * Created at 6/18/19 8:17 PM
 */
public class Test {

  @org.junit.Test
  public void isMatch() {
    Solution solution = new Solution();
    assertTrue(solution.isMatch("abc", "a.."));
    assertFalse(solution.isMatch("aa", "a"));
    assertTrue(solution.isMatch("aa", "a*"));
    assertTrue(solution.isMatch("abcdefg", ".*"));
    assertTrue(solution.isMatch("aab", "c*a*b"));
    assertFalse(solution.isMatch("mississippi", "mis*is*p*.")); // miss 'i' before 'p'
    assertTrue(solution.isMatch("mississippi", "mis*is*ip*."));
  }

  @org.junit.Test
  public void isMatchDP() {
    Solution solution = new Solution();
    assertTrue(solution.isMatchDP("abc", "a.."));
    assertFalse(solution.isMatchDP("aa", "a"));
    assertTrue(solution.isMatchDP("aa", "a*"));
    assertTrue(solution.isMatchDP("abcdefg", ".*"));
    assertTrue(solution.isMatchDP("aab", "c*a*b"));
    assertFalse(solution.isMatchDP("mississippi", "mis*is*p*.")); // miss 'i' before 'p'
    assertTrue(solution.isMatchDP("mississippi", "mis*is*ip*."));
  }
}