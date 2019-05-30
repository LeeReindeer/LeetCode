package moe.leer.leetcode.P062;

import java.util.Arrays;

/**
 * @author leer
 * Created at 5/30/19 4:15 PM
 */
public class Solution {
  // dp[i][j] = dp[i-1][j] + dp[i][j-1]
  // Time: O(mn), Space: O(mn)
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

  // Time: O(mn), Space: O(n)
  // store the previous col, calculate col by col
  public int uniquePaths2(int m, int n) {
    if (m == 0 || n == 0) return 0;
    if (m == 1 || n == 1) return 1;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[j] += dp[j - 1];
      }
      System.out.println(Arrays.toString(dp));
    }
    return dp[n - 1];
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.uniquePaths(3, 2));
    System.out.println(solution.uniquePaths(3, 3));
    System.out.println(solution.uniquePaths(7, 3));
  }
}
