package moe.leer.leetcode.p122;

import static org.junit.Assert.assertEquals;

/**
 * @author leer
 * Created at 2/10/19 1:45 PM
 */
public class Test {

  @org.junit.Test
  public void testCase1() {
    moe.leer.leetcode.p122.Solution solution = new Solution();
    int[] prices = {7, 1, 5, 3, 6, 4};
    int max = solution.maxProfit(prices);
    assertEquals(5 - 1 + 6 - 3, max);
  }

  @org.junit.Test
  public void testCase2() {
    moe.leer.leetcode.p122.Solution solution = new Solution();
    int[] prices = {7, 6, 4, 3, 1};
    int max = solution.maxProfit(prices);
    assertEquals(0, max);
  }

  @org.junit.Test
  public void testMethod2() {
    moe.leer.leetcode.p122.Solution solution = new Solution();
    int[] prices = { 7, 6, 4, 3, 1 };
    int max = solution.maxProfit2(prices);
    assertEquals(0, max);
  }
}