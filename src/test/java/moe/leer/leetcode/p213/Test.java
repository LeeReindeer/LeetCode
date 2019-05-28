package moe.leer.leetcode.p213;

import static org.junit.Assert.assertEquals;

/**
 * @author leer
 * Created at 5/28/19 10:09 AM
 */
public class Test {

  @org.junit.Test
  public void rob() {
    int[] a = new int[]{2, 3, 2};
    int[] b = new int[]{1, 2, 3, 1};
    Solution solution = new Solution();
    assertEquals(3, solution.rob(a));
    assertEquals(4, solution.rob(b));
  }
}