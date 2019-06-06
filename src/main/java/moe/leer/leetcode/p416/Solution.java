package moe.leer.leetcode.p416;

/**
 * @author leer
 * Created at 6/4/19 8:05 PM
 */
class Solution {
  /**
   * Let us assume dp[i][j] means whether the specific sum j can be gotten from the first i numbers.
   * If we can pick such a series of numbers from 0-i whose sum is j, dp[i][j] is true, otherwise it is false.
   * <p>
   * Base case: dp[0][0] is true; (zero number consists of sum 0 is true)
   * <p>
   * Transition function: For each number, if we don't pick it, dp[i][j] = dp[i-1][j],
   * which means if the first i-1 elements has made it to j, dp[i][j] would also make it to j (we can just ignore nums[i]).
   * If we pick nums[i]. dp[i][j] = dp[i-1][j-nums[i]], which represents that j is composed of the current value nums[i]
   * and the remaining composed of other previous numbers. Thus, the transition function is dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]
   */
  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int i : nums) {
      sum += i;
    }
    // sum % 2 != 0
    if ((sum & 1) == 1) {
      return false;
    }
    sum /= 2;
    int n = nums.length;
    boolean[][] dp = new boolean[n + 1][sum + 1];
    dp[0][0] = true;
    for (int i = 1; i <= n; i++) {
      dp[i][0] = true;
    }
    for (int j = 1; j <= sum; j++) {
      dp[0][j] = false;
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= sum; j++) {
        int w = nums[i - 1];
        if (j >= nums[i - 1]) {
          dp[i][j] = dp[i - 1][j] || dp[i - 1][j - w]; // choose the available one
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[n][sum];
  }

  // Space: O(sum)
  public boolean canPartition2(int[] nums) {
    int n = nums.length;
    int sum = 0;
    for (int i : nums) {
      sum += i;
    }
    if (sum % 2 != 0) return false;
    sum /= 2;
    boolean[] dp = new boolean[sum + 1];
    // dp init
    dp[0] = true;
    // dp transition
    for (int i = 1; i < n + 1; i++) {
      for (int j = sum; j >= 1; j--) {
        if (j >= nums[i - 1]) {
          dp[j] = dp[j] || dp[j - nums[i - 1]];
        }
      }
    }
    return dp[sum];
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
    System.out.println(solution.canPartition2(new int[]{1, 5, 11, 5}));
    System.out.println(solution.canPartition(new int[]{1, 2, 3, 5}));
    System.out.println(solution.canPartition2(new int[]{1, 2, 3, 5}));
  }
}
