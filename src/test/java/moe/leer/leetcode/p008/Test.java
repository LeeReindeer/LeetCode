package moe.leer.leetcode.p008;

import static org.junit.Assert.assertEquals;

/**
 * @author leer Created at 1/27/19 6:12 PM
 */
public class Test {

  @org.junit.Test
  public void testAtoi() {
    moe.leer.leetcode.p008.Solution solution = new Solution();

    assertEquals(12345678, solution.myAtoi("0000000000012345678"));
    assertEquals(12345678, solution.myAtoi("+0000000000012345678"));
    assertEquals(0, solution.myAtoi("-"));
    assertEquals(0, solution.myAtoi("-+1"));
    assertEquals(42, solution.myAtoi("42"));
    assertEquals(-42, solution.myAtoi("-42"));
    assertEquals(-42, solution.myAtoi("     -42"));
    assertEquals(4193, solution.myAtoi("4193 with words"));
    assertEquals(0, solution.myAtoi("words and 987"));
    assertEquals(Integer.MAX_VALUE, solution.myAtoi(String.valueOf(Integer.MAX_VALUE)));
    assertEquals(Integer.MAX_VALUE, solution.myAtoi(String.valueOf((long) Integer.MAX_VALUE + 1)));
    assertEquals(0, solution.myAtoi("0-1"));
  }
}
