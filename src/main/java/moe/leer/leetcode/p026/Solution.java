package moe.leer.leetcode.p026;

/**
 * @author leer
 * Created at 2/10/19 1:04 PM
 * <p>
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * It doesn't matter what values are set beyond the returned length.
 * @see moe.leer.leetcode.p026.Test#testCase1()
 */
public class Solution {
  public int removeDuplicates(int[] nums) {
    int len = nums.length;
    if (len < 2) return len;

    int newLen = 1;
    for (int i = 1; i < len; i++) {
      if (nums[i] != nums[i - 1]) nums[newLen++] = nums[i];
    }
    return newLen;
  }
}
