package moe.leer.leetcode.p746;

import static org.junit.Assert.assertEquals;

/**
 * @author leer
 * Created at 5/25/19 1:38 PM
 */
public class Test {

  @org.junit.Test
  public void minCostClimbingStairs() {
    Solution solution = new Solution();
    int[] cost1 = new int[]{10, 15, 20};
    assertEquals(15, solution.minCostClimbingStairs(cost1));
    int[] cost2 = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
    assertEquals(6, solution.minCostClimbingStairs(cost2));
  }
}