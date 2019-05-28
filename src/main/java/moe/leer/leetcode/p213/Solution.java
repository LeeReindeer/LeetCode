package moe.leer.leetcode.p213;

/**
 * @author leer
 * Created at 5/28/19 9:54 AM
 * @see moe.leer.leetcode.p198.Solution#rob2(int[])
 */
public class Solution {
  public int rob(int[] nums) {
    if (nums.length == 0) return 0;
    int len = nums.length;
    if (len == 1) return nums[0];
    // rob from 0 to len -2 or from 1 to len - 1 make it not adjacent in circle
    // select the max one from this two case
    return Math.max(rob(nums, 0, len - 2), rob(nums, 1, len - 1));
  }

  private int rob(int[] nums, int start, int end) {
    int prev1 = 0;
    int prev2 = 0;
    for (int i = start; i <= end; i++) {
      int t = prev1;
      prev1 = Math.max(prev2 + nums[i], prev1);
      prev2 = t;
    }
    return prev1;
  }
}
