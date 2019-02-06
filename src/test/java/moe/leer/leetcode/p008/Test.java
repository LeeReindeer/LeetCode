package moe.leer.leetcode.p008;

import static org.junit.Assert.assertEquals;

/**
 * @author leer Created at 1/27/19 6:12 PM
 */
public class Test {

  @org.junit.Test
  public void testAtoi() {
    moe.leer.leetcode.p008.Solution solution = new Solution();

    assertEquals(solution.myAtoi("0000000000012345678"), 12345678);
    assertEquals(solution.myAtoi("+0000000000012345678"), 12345678);
    assertEquals(solution.myAtoi("-"), 0);
    assertEquals(solution.myAtoi("-+1"), 0);
    assertEquals(solution.myAtoi("42"), 42);
    assertEquals(solution.myAtoi("-42"), -42);
    assertEquals(solution.myAtoi("     -42"), -42);
    assertEquals(solution.myAtoi("4193 with words"), 4193);
    assertEquals(solution.myAtoi("words and 987"), 0);
    assertEquals(solution.myAtoi(String.valueOf(Integer.MAX_VALUE)), Integer.MAX_VALUE);
    assertEquals(solution.myAtoi(String.valueOf((long) Integer.MAX_VALUE + 1)), Integer.MAX_VALUE);
  }
}
