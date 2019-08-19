package moe.leer.leetcode.p055;

/**
 * @author leer
 * Created at 8/22/19 9:23 PM
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class Solution {

  public boolean canJump(int[] nums) {
    return backtracking(0, nums);
  }

  // Time: O(2^n)
  // TLE
  private boolean backtracking(int start, int[] nums) {
    if (start == nums.length - 1) {
      return true;
    }
    for (int j = 1; j <= nums[start]; j++) {
      int next = start + j;
      System.out.println("next: " + next);
      if (next < nums.length)
        if (backtracking(next, nums))
          return true;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().canJump(new int[]{2, 3, 1, 1, 4}));
    System.out.println(new Solution().canJump(new int[]{2, 0, 0}));
    System.out.println(new Solution().canJump(new int[]{3, 2, 1, 0, 4}));
  }
}
