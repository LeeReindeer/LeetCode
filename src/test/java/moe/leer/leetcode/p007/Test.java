package moe.leer.leetcode.p007;

import static org.junit.Assert.assertEquals;

/**
 * @author leer
 * Created at 4/29/19 6:42 PM
 */
public class Test {
  @org.junit.Test
  public void test1() {
    Solution solution = new Solution();
    assertEquals(321, solution.reverse(123));
    assertEquals(-123, solution.reverse(-321));
    assertEquals(21, solution.reverse(120));
    assertEquals(0, solution.reverse(0));
    assertEquals(0, solution.reverse(-2147483648));
  }
}
