package moe.leer.leetcode.p121;

import static org.junit.Assert.assertEquals;

/**
 * @author leer
 * Created at 2/11/19 9:06 PM
 */
public class Test {

  @org.junit.Test
  public void testCase() {
    moe.leer.leetcode.p121.Solution solution = new Solution();
    int max = solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    assertEquals(5, max);

    max = solution.maxProfit(new int[]{7, 6, 5, 4, 3});
    assertEquals(0, max);
  }
}