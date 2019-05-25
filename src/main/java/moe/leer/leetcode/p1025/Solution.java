package moe.leer.leetcode.p1025;

import java.util.Arrays;

/**
 * @author leer
 * Created at 5/25/19 1:06 PM
 */
public class Solution {
  // dp[i] represents whether the first player can win with number i
  public boolean divisorGame(int N) {
    boolean[] dp = new boolean[N + 1];
    Arrays.fill(dp, false);
    for (int i = 1; i <= N; i++) {
      for (int x = 1; x < i; x++) {
        if (i % x == 0 && !dp[i - x]) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[N];
  }
}
