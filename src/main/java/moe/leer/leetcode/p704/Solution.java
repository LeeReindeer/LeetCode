package moe.leer.leetcode.p704;

/**
 * @author leer
 * Created at 7/19/19 8:38 PM
 */
public class Solution {
  public int search(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    while (l <= r) {
      int mid = l + (r - l) /2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return -1;
  }
}
