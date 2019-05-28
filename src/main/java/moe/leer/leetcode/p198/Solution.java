package moe.leer.leetcode.p198;

import java.util.Arrays;

/**
 * @author leer
 * Created at 5/25/19 2:40 PM
 */
public class Solution {
  // if we robbed i-th houses, we can't rob i-1 th hourse
  // dp[i] = max(dp[i-2]+nums[i], dp[i-1])
  public int rob(int[] nums) {
    int len = nums.length;
    if (len == 0) return 0;
    int[] dp = new int[len + 1];
    Arrays.fill(dp, 0);
    dp[0] = 0;
    dp[1] = nums[0];
    for (int i = 1; i < len; i++) {
      dp[i + 1] = Math.max(dp[i - 1] + nums[i], dp[i]);
    }
    return dp[len];
  }

  public int rob2(int[] nums) {
    if (nums.length == 0) return 0;
    int prev1 = 0;
    int prev2 = 0;
    for (int num : nums) {
      int t = prev1;
      prev1 = Math.max(prev2 + num, prev1);
      prev2 = t;
    }
    return prev1;
  }

  // top-down recursive + memoized
  int[] memo;
  public int rob3(int[] nums) {
    memo = new int[nums.length + 1];
    Arrays.fill(memo, -1);
    return rob_recursive(nums, nums.length - 1);
  }

  private int rob_recursive(int[] nums, int i) {
    if (i < 0) return 0;
    if (memo[i] >= 0) return memo[i];
    int max = Math.max(rob_recursive(nums, i - 2) + nums[i], rob_recursive(nums, i - 1));
    memo[i] = max;
    return max;
  }
}
