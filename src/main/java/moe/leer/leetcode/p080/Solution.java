package moe.leer.leetcode.p080;

/**
 * @author leer
 * Created at 1/16/20 3:27 PM
 * <p>
 * 80. Remove Duplicates from Sorted Array II
 * <p>
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 */
public class Solution {
  public int removeDuplicates(int[] nums) {
    int i = 0;
    for (int n : nums) {
      if (i < 2 || n > nums[i - 2]) { // allow duplicates up to 2
        nums[i++] = n;
      }
    }
    return i;
  }
}
