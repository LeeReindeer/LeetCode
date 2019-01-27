package moe.leer.leetcode.p200;

/**
 * @author leer
 * Created at 1/27/19 7:15 PM
 */
public class Solution {

  private int row;
  private int col;
  private char[][] g;

  public int numIslands(char[][] grid) {
    int island = 0;
    row = grid.length;
    if (row == 0) return 0;
    col = grid[0].length;

    g = grid;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (g[i][j] == '1') {
          dfsFlowLand(i, j); // let water flow the land
          island++;
        }
      }
    }
    return island;
  }

  private void dfsFlowLand(int i, int j) {
    if (i < 0 || j < 0 || i >= row || j >= col || g[i][j] == '0') return;
    g[i][j] = '0';
    dfsFlowLand(i + 1, j); // up
    dfsFlowLand(i, j + 1); // right
    dfsFlowLand(i - 1, j); // up
    dfsFlowLand(i, j - 1); // down
  }
}
