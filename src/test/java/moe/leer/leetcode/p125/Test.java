package moe.leer.leetcode.p125;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author leer
 * Created at 5/4/19 2:23 PM
 */
public class Test {
  @org.junit.Test
  public void test1() {
    Solution solution = new Solution();
    assertFalse(solution.isPalindrome("0P"));
    assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"));
    assertFalse(solution.isPalindrome("race a car"));
  }
}
