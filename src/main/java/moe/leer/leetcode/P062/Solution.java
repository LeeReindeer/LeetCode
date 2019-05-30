package moe.leer.leetcode.P062;

/**
 * @author leer
 * Created at 5/30/19 4:15 PM
 */
public class Solution {
  // dp[i][j] = dp[i-1][j] + dp[i][j-1]
  public int uniquePaths(int m, int n) {
    if (m == 0 || n == 0) return 0;
    if (m == 1 || n == 1) return 1;
    int[][] dp = new int[m][n];
    dp[0][0] = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) {
          if (i == 0 && j == 0) continue;
          dp[i][j] = 1;
          continue;
        }
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[m - 1][n - 1];
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.uniquePaths(3, 2));
    System.out.println(solution.uniquePaths(3, 3));
    System.out.println(solution.uniquePaths(7, 3));
  }
}
