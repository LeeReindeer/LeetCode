package moe.leer.leetcode.p695;

/**
 * @author leer
 * Created at 6/10/19 8:22 PM
 * Given a non-empty 2D array grid of 0's and 1's,
 * an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 * <p>
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 */
class Solution {
  private int row, col;
  private int[][] grid;
  private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  // when encounter 1, do dfs, mark traveled island(1) as 0, so it won't be repeated count.
  public int maxAreaOfIsland(int[][] grid) {
    if (grid.length == 0) return 0;
    this.grid = grid;
    row = grid.length;
    col = grid[0].length;
    int maxArea = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == 1) {
          maxArea = Math.max(maxArea, dfs(i, j));
        }
      }
    }
    return maxArea;
  }

  private int dfs(int r, int c) {
    if (r < 0 || r >= row || c < 0 || c >= col || grid[r][c] == 0)
      return 0;
    //mark as traveled
    grid[r][c] = 0;
    int area = 1;
    for (int[] d : dirs) {
      area += dfs(r + d[0], c + d[1]);
    }
    return area;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] grid = new int[][]{
        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
    System.out.println(solution.maxAreaOfIsland(grid));
  }
}
