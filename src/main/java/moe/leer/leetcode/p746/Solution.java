package moe.leer.leetcode.p746;

import java.util.Arrays;

/**
 * @author leer
 * Created at 5/25/19 1:16 PM
 * <p>
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * <p>
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
 * <p>
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on ones, skipping cost[3].
 */
public class Solution {
  // dp[i] represents min cost to i stair
  // dp[i] = cost[i] +  min(dp[i - 1], dp[i - 2])
  // Note: you can either start from the step with index 0, or the step with index 1
  // return the min
  // Time: O(n), Space: O(n)
  public int minCostClimbingStairs(int[] cost) {
    int len = cost.length;
    int[] dp = new int[len];
    Arrays.fill(dp, 0);
    dp[0] = cost[0];
    dp[1] = cost[1];
    for (int i = 2; i < len; i++) {
      dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
    }
//    Util.printArray(dp);
    return Math.min(dp[len - 1], dp[len - 2]);
  }

  // Time: O(n), Space: O(1)
  public int minCostClimbingStairs2(int[] cost) {
    int len = cost.length;
    for (int i = 2; i < len; i++) {
      cost[i] += Math.min(cost[i - 1], cost[i - 2]);
    }
    return Math.min(cost[len - 2], cost[len - 2]);
  }

}
