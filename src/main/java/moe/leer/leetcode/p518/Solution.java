package moe.leer.leetcode.p518;

/**
 * @author leer
 * Created at 8/16/19 4:23 PM
 */
public class Solution {

  // Time:O(m*n), Space: O(m*n)
  // dp[i][j] : the number of combinations to make up amount j using first i coins
  // 1. not using the i th coin, so we have dp[i-1][j] ways
  // 2. using the i th coin, need to know how many ways to make up amount j-coins[i-1]
  public int change2(int amount, int[] coins) {
    int[][] dp = new int[coins.length + 1][amount + 1];
    dp[0][0] = 1;
    for (int i = 1; i <= coins.length; i++) {
      dp[i][0] = 1;
      for (int j = 1; j <= amount; j++) {
        dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
      }
    }
    return dp[coins.length][amount];
  }

  // Space: O(m)
  public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int coin : coins) {
      for (int i = coin; i <= amount; i++) {
        dp[i] = dp[i] + dp[i - coin];
      }
    }
    return dp[amount];
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.change2(5, new int[]{1, 2, 5}));
    System.out.println(solution.change(5, new int[]{1, 2, 5}));
  }
}
