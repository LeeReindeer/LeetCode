package moe.leer.leetcode.p053;

import static org.junit.Assert.assertEquals;

/**
 * @author leer
 * Created at 6/3/19 3:51 PM
 */
public class Test {

  @org.junit.Test
  public void maxSubArray() {
    Solution solution = new Solution();
    int[] a = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int[] b = new int[]{-2, -1, -3, -4, -1, -2,};
    int[] c = new int[]{1};
    int[] d = new int[]{-1, -2};
    int[] e = new int[]{-2, -1};
    assertEquals(solution.maxSubArray(a), solution.maxSubArray2(a));
    System.out.println(solution.maxSubArray(a));

    assertEquals(solution.maxSubArray(b), solution.maxSubArray2(b));
    System.out.println(solution.maxSubArray(b));
    assertEquals(solution.maxSubArray(c), solution.maxSubArray2(c));
    System.out.println(solution.maxSubArray2(c));
    assertEquals(solution.maxSubArray(d), solution.maxSubArray2(d));
    System.out.println(solution.maxSubArray2(d));
    assertEquals(solution.maxSubArray(e), solution.maxSubArray2(e));
    System.out.println(solution.maxSubArray2(e));
  }
}