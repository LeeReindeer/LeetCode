package moe.leer.leetcode.p303;

/**
 * @author leer
 * Created at 6/1/19 9:45 PM
 */
public class Solution {
  static class NumArray {

    private int[] dp;

    /*
    public NumArray(int[] nums) {
      this.nums = nums;
    }

    // O(n)
    public int sumRange(int i, int j) {
      int sum = 0;
      for (int k = i; k <= j; k++) {
        sum += nums[k];
      }
      return sum;
    }
    */

    // dp[i] = dp[i-1] + nums[i-1]
    // dp[i] is sum of of 0 ~ i-1
    public NumArray(int[] nums) {
      this.dp = new int[nums.length + 1];
      for (int i = 1; i <= nums.length; i++) {
        dp[i] = dp[i - 1] + nums[i - 1];
      }
    }

    // O(1)
    public int sumRange(int i, int j) {
      return dp[j + 1] - dp[i];
    }
  }

  /**
   * Your NumArray object will be instantiated and called as such:
   * NumArray obj = new NumArray(nums);
   * int param_1 = obj.sumRange(i,j);
   */
  public static void main(String[] args) {
    int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
    NumArray numArray = new NumArray(nums);
    System.out.println(numArray.sumRange(0, 2));
    System.out.println(numArray.sumRange(2, 5));
    System.out.println(numArray.sumRange(0, 5));
  }
}
