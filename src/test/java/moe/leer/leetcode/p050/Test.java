package moe.leer.leetcode.p050;

import static org.junit.Assert.assertEquals;

/**
 * @author leer
 * Created at 6/29/19 1:33 PM
 */
public class Test {

  @org.junit.Test
  public void myPow() {
    Solution solution = new Solution();
    assertEquals(1024.00000, solution.myPow(2.0, 10), 1E-6);
    assertEquals(9.26100, solution.myPow(2.1, 3), 1E-6);
    assertEquals(0.25, solution.myPow(2.0, -2), 1E-6);
    assertEquals(4, solution.myPow(2.0, 2), 1E-6);
    assertEquals(4, solution.myPow(-2.0, 2), 1E-6);
    assertEquals(0.0, solution.myPow(2.0, -2147483648), 1E-6);
  }
}