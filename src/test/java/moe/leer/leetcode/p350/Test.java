package moe.leer.leetcode.p350;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author leer
 * Created at 2/18/19 4:28 PM
 */
public class Test {

  @org.junit.Test
  public void testCase1() {
    int[] nums1 = new int[]{1, 2, 2, 1};
    int[] nums2 = new int[]{2, 2};
    moe.leer.leetcode.p350.Solution solution = new Solution();
    assertArrayEquals(new int[]{2, 2}, solution.intersect(nums1, nums2));

    assertArrayEquals(new int[]{9, 4}, solution.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
  }

  @org.junit.Test
  public void testCase2() {
    int[] nums1 = new int[]{1, 2, 2, 1};
    int[] nums2 = new int[]{2, 2};
    moe.leer.leetcode.p350.Solution solution = new Solution();
    assertArrayEquals(new int[]{2, 2}, solution.intersect2(nums1, nums2));

    assertArrayEquals(new int[]{9, 4}, solution.intersect2(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
  }

}