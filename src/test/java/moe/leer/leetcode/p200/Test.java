package moe.leer.leetcode.p200;

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
    grid1 = int2char(new int[][]{
        {1, 1, 1, 1, 0},
        {1, 1, 0, 1, 0},
        {1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0},
    }, 4, 5);

    grid2 = int2char(new int[][]{
        {1, 1, 0, 0, 0},
        {1, 1, 0, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 0, 1, 1},
    }, 4, 5);
  }

  public char[][] int2char(int[][] g, int row, int col) {
    char[][] chars = new char[row][col];
    if (row == 0) {
      return chars;
    }
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        chars[i][j] = (char) (g[i][j] + '0');
      }
    }
    return chars;
  }

  @org.junit.Test
  public void test() {
    moe.leer.leetcode.p200.Solution solution = new Solution();

    assertEquals(1, solution.numIslands(grid1));
    assertEquals(3, solution.numIslands(grid2));
  }
}
