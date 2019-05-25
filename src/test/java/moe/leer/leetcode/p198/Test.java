package moe.leer.leetcode.p198;

import static org.junit.Assert.*;

/**
 * @author leer
 * Created at 5/25/19 3:14 PM
 */
public class Test {

  @org.junit.Test
  public void rob() {
    Solution solution = new Solution();
    int[] a = new int[]{2, 1, 1, 2};
    int max1 = solution.rob(a);
    int max2 = solution.rob2(a);
    int max3 = solution.rob3(a);
    System.out.println(solution.rob3(a));
    assertEquals(4, max1);
    assertEquals(max2, max1);
    assertEquals(max3, max1);
  }
}