package moe.leer.leetcode.p283;

import moe.leer.leetcode.Util;

/**
 * @author leer
 * Created at 2/20/19 2:59 PM
 * <p>
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class Solution {

  private void swap(int[] nums, int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
  }

  // O(n^2)
  public void moveZeroes(int[] nums) {
    if (nums.length <= 1) return;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == 0) {
        int j = i + 1;
        // find next non-zero element
        while (nums[j] == 0 && j < nums.length - 1) j++;
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
      }
    }
  }

  // O(n)
  public void moveZeroes2(int[] nums) {
    if (nums.length <= 1) return;
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
        j++;
      }
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] a = new int[]{0, 1, 0, 3, 12};
    solution.moveZeroes(a);
    Util.printArray(a);
    int[] b = new int[]{0, 0, 1, 2, 3};
    solution.moveZeroes2(b);
    Util.printArray(b);
  }
}
