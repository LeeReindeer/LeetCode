package moe.leer.leetcode.p053;

/**
 * @author leer
 * Created at 6/3/19 3:15 PM
 */
class Solution {

  // dp[i] is the max sum of array end with nums[i]
  // dp[i] = max(nums[i], dp[i-1] + nums[i])
  // Time: O(n), Space: O(n)
  public int maxSubArray(int[] nums) {
    if (nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
      if (dp[i] > max) {
        max = dp[i];
      }
    }
//    Util.printArray(dp);
    return max;
  }

  // Time: O(n), Space: O(1)
  public int maxSubArray2(int[] nums) {
    int max = nums[0];
    int prev = nums[0];
    int cur = 0;
    for (int i = 1; i < nums.length; i++) {
      cur = Math.max(nums[i], prev + nums[i]);
      if (cur > max) max = cur;
      prev = cur;
    }
    return max;
  }

  public static void main(String[] args) {
  }
}
