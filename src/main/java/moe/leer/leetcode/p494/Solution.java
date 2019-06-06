package moe.leer.leetcode.p494;

/**
 * @author leer
 * Created at 6/6/19 4:33 PM
 */
class Solution {
  // positive: sum(p), negative:sum(n)
  // sum(p) - sum(n) = target
  // sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
  // 2 * sum(P) = target + sum(nums)
  // So if we find a positive collection sum of (target + sum(nums))/2,
  // we find a way of the origin problem.
  // dp[i][j] presents the ways that make all positive numbers' sum is j.
  // dp[i][j] = dp[i-1][j] + dp[i-1][j-num[i]]
  public int findTargetSumWays(int[] nums, int S) {
    int n = nums.length;
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum < S || (sum + S) % 2 != 0) return 0;
    int W = (sum + S) / 2;
    int[] dp = new int[W + 1];
    dp[0] = 1;
    for (int i = 0; i < n; i++) {
      for (int j = W; j >= nums[i]; j--) {
        dp[j] = dp[j] + dp[j - nums[i]];
      }
    }
    return dp[W];
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
  }
}
