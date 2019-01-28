package moe.leer.leetcode.p200;

import moe.leer.leetcode.Util;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

/**
 * @author leer
 * Created at 1/27/19 7:33 PM
 */
public class Test {

  char[][] grid1;
  char[][] grid2;

  @Before
  public void init() {
    grid1 = Util.int2char(new int[][]{
        {1, 1, 1, 1, 0},
        {1, 1, 0, 1, 0},
        {1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0},
    }, 4, 5);

    grid2 = Util.int2char(new int[][]{
        {1, 1, 0, 0, 0},
        {1, 1, 0, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 0, 1, 1},
    }, 4, 5);
  }

  @org.junit.Test
  public void test() {
    moe.leer.leetcode.p200.Solution solution = new Solution();

    assertEquals(1, solution.numIslands(grid1));
    assertEquals(3, solution.numIslands(grid2));
  }
}
