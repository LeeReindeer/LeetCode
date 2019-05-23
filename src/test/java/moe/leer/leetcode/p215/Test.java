package moe.leer.leetcode.p215;

import static org.junit.Assert.assertEquals;

/**
 * @author leer
 * Created at 5/23/19 3:08 PM
 */
public class Test {

  @org.junit.Test
  public void findKthLargest() {
    int[] a = new int[]{3, 2, 1, 5, 6, 4};
    Solution solution = new Solution();
    assertEquals(5, solution.findKthLargest(a, 2));
  }

  @org.junit.Test
  public void testNotDistinct() {
    int[] a = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
    Solution solution = new Solution();
    assertEquals(4, solution.findKthLargest(a, 4));
  }
}