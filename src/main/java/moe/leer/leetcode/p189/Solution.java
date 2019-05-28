package moe.leer.leetcode.p189;

/**
 * @author leer
 * Created at 2/13/19 9:21 PM
 * <p>
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
public class Solution {

  //Time: O(n), space: O(n)
  public void rotate2(int[] nums, int k) {
    k %= nums.length;
    if (k == 0 || nums.length <= 1) return;

    int[] aux = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      aux[(i + k) % nums.length] = nums[i];
    }
    for (int i = 0; i < nums.length; i++) {
      nums[i] = aux[i];
    }
  }

  // in-place
  // Time: O(k*n)
  public void rotate(int[] nums, int k) {
    k %= nums.length;
    if (k == 0 || nums.length <= 1) return;
    for (int i = 1; i <= k; i++) {
      int tmp = nums[nums.length - 1];
      for (int j = nums.length - 1; j > 0; j--) {
        nums[j] = nums[j - 1];
      }
      nums[0] = tmp;
    }
  }
}
