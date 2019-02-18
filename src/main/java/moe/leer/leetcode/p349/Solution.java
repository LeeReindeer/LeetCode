package moe.leer.leetcode.p349;

import java.util.HashSet;

/**
 * @author leer
 * Created at 2/18/19 3:01 PM
 */
public class Solution {

  // Time: O(n), Space: O(n)
  public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> intersection = new HashSet<>();
    HashSet<Integer> map = new HashSet<>();
    for (int i = 0; i < nums1.length; i++) {
      map.add(nums1[i]);
    }
    for (int i = 0; i < nums2.length; i++) {
      if (map.contains(nums2[i])) {
        intersection.add(nums2[i]);
      }
    }
    return intersection.stream().mapToInt(k -> k).toArray();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] a = new int[]{1, 2, 2, 1};
    int[] b = new int[]{2, 2};
    int[] c = solution.intersection(a, b);

    for (int i = 0; i < c.length; i++) {
      System.out.printf("%d ", c[i]);
    }
    System.out.println();
  }
}
