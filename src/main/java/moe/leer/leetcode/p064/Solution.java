package moe.leer.leetcode.p064;

@SuppressWarnings("Duplicates")
class Solution {
  // dp[i][j] = mine(dp[i-1][j], dp[i][j-1]) + grid[i][j]
  // Time: O(mn), Space: O(mn)
  public int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] dp = new int[m][n];
    dp[0][0] = grid[0][0];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i != 0 && j == 0) { // top
          dp[i][j] = dp[i - 1][j] + grid[i][j];
        } else if (i == 0 && j != 0) { // left to this point only
          dp[i][j] = dp[i][j - 1] + grid[i][j];
        } else if (i > 0 && j > 0) {
          // min of top and left plus this
          dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
        }
      }
    }
    return dp[m - 1][n - 1];
  }

  public int minPathSum2(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[] dp = new int[n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (j == 0) { // top
          dp[j] = dp[j];
        } else if (i == 0) { // left
          dp[j] = dp[j - 1];
        } else {
          dp[j] = Math.min(dp[j - 1], dp[j]);
        }
        dp[j] += grid[i][j];
      }
    }
    return dp[n - 1];
  }

  // Time: O(mn), Space: O(1)
  // Modify the origin grid
  public int minPathSum3(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i - 1 >= 0 && j - 1 >= 0) {
          grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
        } else if (i - 1 < 0 && j - 1 >= 0) {
          grid[i][j] = grid[i][j - 1] + grid[i][j];
        } else if (i - 1 >= 0 && j - 1 < 0) {
          grid[i][j] = grid[i - 1][j] + grid[i][j];
        }
      }
    }
    return grid[m - 1][n - 1];
  }
}