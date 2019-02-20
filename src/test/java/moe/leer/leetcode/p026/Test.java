package moe.leer.leetcode.p026;

import moe.leer.leetcode.TestUtil;

import static org.junit.Assert.assertEquals;

/**
 * @author leer
 * Created at 2/10/19 1:36 PM
 */
public class Test {

  @org.junit.Test
  public void testCase1() {
    int[] a = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    moe.leer.leetcode.p026.Solution solution = new Solution();
    int len = solution.removeDuplicates(a);
    TestUtil.printArray(a, len);

    assertEquals(5, len);
  }
}
