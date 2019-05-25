package moe.leer.leetcode.p070;

import static org.junit.Assert.*;

/**
 * @author leer
 * Created at 5/25/19 2:14 PM
 */
public class Test {

  @org.junit.Test
  public void climbStairs() {
    Solution solution = new Solution();
    assertEquals(10946, solution.climbStairs(20));
    assertEquals(10946, solution.climbStairs2(20));
  }
}