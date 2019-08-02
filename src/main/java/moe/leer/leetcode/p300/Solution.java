package moe.leer.leetcode.p300;

import java.util.Arrays;

/**
 * @author leer
 * Created at 8/2/19 10:20 PM
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */
public class Solution {

  // Recursive
  // 1. current element > previous element: include current or not include
  // 2. current element <= previous, can not include current
  // 3. return max of include and not include current element
  // Time complexity : O(2^n), Size of recursion tree will be 2^n
  public int lengthOfLIS1(int[] nums) {
    return lengthOfLIS1(nums, Integer.MIN_VALUE, 0);
  }

  private int lengthOfLIS1(int[] nums, int prev, int curIndex) {
    if (curIndex == nums.length) return 0;
    int taken = 0;
    // take current element
    if (nums[curIndex] > prev) {
      taken = 1 + lengthOfLIS1(nums, nums[curIndex], curIndex + 1);
    }
    // not take current
    int noTaken = lengthOfLIS1(nums, prev, curIndex + 1);
    return Math.max(taken, noTaken);
  }

  // DP
  // Recursive with memo
  // Time: O(n^2), size of recursion tree is n^2
  // Space: O(n^2)
  public int lengthOfLIS2(int[] nums) {
    // store combination prevIndex and currIndex
    int[][] memo = new int[nums.length + 1][nums.length];
    for (int[] m : memo) {
        Arrays.fill(m, Integer.MIN_VALUE);
    }
    return lengthOfLIS2(nums, -1, 0, memo);
  }

  private int lengthOfLIS2(int[] nums, int prevIndex, int currIndex, int[][] memo) {
    if (currIndex == nums.length) return 0;
    if (memo[prevIndex + 1][currIndex] != Integer.MIN_VALUE) {
      return memo[prevIndex + 1][currIndex];
    }
    int taken = 0;
    if (prevIndex < 0 || nums[currIndex] > nums[prevIndex]) {
      taken = 1 + lengthOfLIS2(nums, currIndex, currIndex + 1, memo);
    }
    int noTaken = lengthOfLIS2(nums, prevIndex, currIndex + 1, memo);
    memo[prevIndex + 1][currIndex] = Math.max(taken, noTaken);
    return memo[prevIndex + 1][currIndex];
  }

  /**
   * TODO bottom-up dp
   * dp[i] presents LIS length for these i element before.
   * Time: O(n^2)
   * Space: O(n)
   */
  public int lengthOfLIS(int[] nums) {
    return 0;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = new int[]{10,9,2,5,3,7,101,18};
    System.out.println(solution.lengthOfLIS1(nums));
    System.out.println(solution.lengthOfLIS2(nums));
  }
}
