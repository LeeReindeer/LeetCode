package moe.leer.leetcode.p004;

import java.util.Arrays;

/**
 * @author leer
 * Created at 7/25/19 5:04 PM
 */
public class Solution {

  private int[] merge(int[] nums1, int[] nums2) {
    int[] result = new int[nums1.length + nums2.length];
    int i = 0, j =0;
    for (int k = 0; k < result.length; k++) {
      if (i >= nums1.length) {
        result[k] = nums2[j++];
      } else if (j >= nums2.length) {
        result[k] = nums1[i++];
      } else if(nums1[i] < nums2[j]) {
        result[k] = nums1[i++];
      } else {
        result[k] = nums2[j++];
      }
    }
    return result;
  }

  // Time: O(n+m), Space: O(n + m)
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    double result = 0;
    int[] mergedArray = merge(nums1, nums2);
    int len = mergedArray.length;
    int mid = len >>> 1;
    if ((len & 1) == 1) {
      result = mergedArray[mid];
    } else {
      int first = mergedArray[mid];
      int second = mergedArray[mid - 1];
      result = (double) (first + second) / 2;
    }
    return result;
  }

  public static void main(String[] args) {
    Solution solution  = new Solution();
    System.out.println(Arrays.toString(solution.merge(new int[]{1, 3}, new int[]{2})));
    System.out.println(Arrays.toString(solution.merge(new int[]{1, 2}, new int[]{3, 4, 5})));
    System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
  }
}
