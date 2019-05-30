package moe.leer.leetcode.p064;

import static org.junit.Assert.assertEquals;

/**
 * @author leer
 * Created at 5/30/19 4:03 PM
 */
public class Test {

  int[][] grid = new int[][]{
      {1, 3, 1},
      {1, 5, 1},
      {4, 2, 1}};

  @org.junit.Test
  public void minPathSum() {
    Solution solution = new Solution();
    assertEquals(7, solution.minPathSum(grid));
  }

  @org.junit.Test
  public void minPathSum2() {
    Solution solution = new Solution();
    assertEquals(7, solution.minPathSum2(grid));
  }
}