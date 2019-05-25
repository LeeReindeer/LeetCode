package moe.leer.leetcode.p070;

/**
 * @author leer
 * Created at 5/25/19 2:00 PM
 * <p>
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * @see moe.leer.leetcode.p746.Solution#minCostClimbingStairs(int[])
 * 第 i 个楼梯可以从第 i-1 和 i-2 个楼梯到达，所以走到第 i 个楼梯的方法数为走到第 i-1 和第 i-2 个楼梯的方法数之和，
 * 和 Fibonacc 很像。
 */
public class Solution {
  public int climbStairs(int n) {
    if (n <= 2) return n;
    int[] dp = new int[n];
    dp[0] = 1;
    dp[1] = 2;
    for (int i = 2; i < n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n - 1];
  }

  public int climbStairs2(int n) {
    if (n <= 2) return n;
    int ototoi = 1;
    int kinou = 2;
    for (int i = 2; i < n; i++) {
      int kyou = ototoi + kinou;
      ototoi = kinou;
      kinou = kyou;
    }
    return kinou;
  }

  private int fib(int n) {
    if (n <= 2) return 1;
    if (n == 3) return 2;
    int ototoi = 1;
    int kinou = 2;
    for (int i = 3; i < n; i++) {
      int kyou = ototoi + kinou;
      ototoi = kinou;
      kinou = kyou;
    }
    return kinou;
  }
}
