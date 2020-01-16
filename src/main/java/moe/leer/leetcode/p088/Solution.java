package moe.leer.leetcode.p088;

import moe.leer.leetcode.Util;

import java.util.Arrays;

/**
 * @author leer
 * Created at 7/2/19 6:59 PM
 * <p>
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 */
public class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    // merge aux(origin nums1) and nums2 to nums1
    int[] aux = Arrays.copyOf(nums1, m);
    int i = 0, j = 0;
    for (int k = 0; k < m + n; k++) {
      if (i >= m) nums1[k] = nums2[j++];
      else if (j >= n) nums1[k] = aux[i++];
      else if (aux[i] < nums2[j]) nums1[k] = aux[i++];
      else nums1[k] = nums2[j++];
    }
  }

  // no aux array, from tail to head, non-overlapping
  public void merge2(int[] nums1, int m, int[] nums2, int n) {
    int index1 = m - 1, index2 = n - 1, p = m + n - 1;
    while (index1 >= 0 || index2>= n) {
      if (index1 < 0) {
        nums1[p--] = nums2[index2--];
      } else if (index2 < 0) {
        nums1[p--] = nums1[index1--];
      } else if (nums1[index1] > nums2[index2]) {
        nums1[p--] = nums1[index1--];
      } else {
        nums1[p--] = nums2[index2--];
      }
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
    int[] nums2 = new int[]{2, 5, 6};
    solution.merge2(nums1, 3, nums2, 3);
    Util.printArray(nums1);
  }
}
