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
        if (i - 1 >= 0 && j - 1 >= 0) {
          dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
        } else if (i - 1 < 0 && j - 1 >= 0) {
          dp[i][j] = dp[i][j - 1] + grid[i][j];
        } else if (i - 1 >= 0 && j - 1 < 0) {
          dp[i][j] = dp[i - 1][j] + grid[i][j];
        }
      }
    }
    return dp[m - 1][n - 1];
  }

  // Time: O(n), SPace: O(1)
  // Modify the origin grid
  public int minPathSum2(int[][] grid) {
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


  public static void main(String[] args) {

  }
}