package moe.leer.leetcode.p413;

import static org.junit.Assert.assertEquals;

/**
 * @author leer
 * Created at 6/2/19 3:16 PM
 */
public class Test {

  @org.junit.Test
  public void numberOfArithmeticSlices() {
    Solution solution = new Solution();
    int[] a = new int[]{1, 2, 3, 4};
    int[] b = new int[]{1, 2, 3, 4, 0, 0, 7, 8, 9};
    assertEquals(3, solution.numberOfArithmeticSlices(a));
    assertEquals(4, solution.numberOfArithmeticSlices(b));
    System.out.println(solution.numberOfArithmeticSlices2(new int[]{1, 2, 3, 4}));
    System.out.println(solution.numberOfArithmeticSlices2(new int[]{1, 2, 3, 4, 0, 0, 7, 8, 9}));
  }
}