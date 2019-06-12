package moe.leer.leetcode.p322;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author leer
 * Created at 6/12/19 10:01 AM
 */
public class Solution {
  // dp[i] presents least number pf coins that make up i
  // dp[i] = min(dp[])
  public int coinChange(int[] coins, int amount) {
    return -1;
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
    System.out.println(solution.coinChangeBFS(coins1, 3));
  }
}
