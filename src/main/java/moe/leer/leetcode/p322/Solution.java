package moe.leer.leetcode.p322;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author leer
 * Created at 6/12/19 10:01 AM
 * <p>
 *  322. Coin Change
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 */
public class Solution {
  // @see https://leetcode.com/articles/coin-change/
  // bottom up dp
  // dp[i] presents least number of coins that make up i
  // dp[i] = min(dp[i-Cj] + 1), (0 <= j <= n)
  // Time: O(c*amount)
  public int coinChange(int[] coins, int amount) {
    if (coins.length == 0) return -1;
    if (amount == 0) return 0;
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;// dp init
    for (int i = 1; i <= amount; i++) {
      for (int c : coins) {
        if (i >= c) dp[i] = Math.min(dp[i], dp[i - c] + 1);
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }

  // top down dp
  public int coinChange2(int[] coins, int amount) {
    if (amount < 1) return 0;
    return helper(coins, amount, new int[amount]);
  }

  private int helper(int[] coins, int rem, int[] count) {
    if (rem < 0) return -1;
    if (rem == 0) return 0; // base
    if (count[rem - 1] != 0) return count[rem - 1]; // already computed
    int min = Integer.MAX_VALUE;
    for (int c : coins) {
      int res = helper(coins, rem - c, count);
      if (res >= 0 && res < min) min = 1 + res;
    }
    count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
    return count[rem - 1];
  }


  /**
   * @see moe.leer.leetcode.p279.Solution#numSquares(int)
   */
  public int coinChangeBFS(int[] coins, int amount) {
    if (coins.length == 0) return -1;
    if (amount == 0) return 0;
    Queue<Integer> q = new LinkedList<>();
    boolean[] visited = new boolean[amount + 1];
    visited[amount] = true;
    q.add(amount);
    int level = 0;
    while (!q.isEmpty()) {
      level++;
      int size = q.size();
      while (size-- > 0) {
        int curAmount = q.poll();
        for (int c : coins) {
          int next = curAmount - c;
          if (next < 0) {
            continue;
          } else if (next == 0) {
            return level;
          }
          if (!visited[next]) {
            visited[next] = true;
            q.add(next);
          }
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] coins = new int[]{1, 2, 5};
    int[] coins1 = new int[]{2};
    System.out.println(solution.coinChangeBFS(coins, 100));
    System.out.println(solution.coinChange(coins, 100));
    System.out.println(solution.coinChange2(coins, 100));
  }
}
