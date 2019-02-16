package moe.leer.leetcode.p217;

import static org.junit.Assert.*;

/**
 * @author leer
 * Created at 2/16/19 7:10 PM
 */
public class Test {

  @org.junit.Test
  public void testCase1() {
    moe.leer.leetcode.p217.Solution solution = new Solution();
    int[] a = new int[]{1, 2, 3, 1};
    assertTrue(solution.containsDuplicate(a));
  }

  @org.junit.Test
  public void testCase2() {
    moe.leer.leetcode.p217.Solution solution = new Solution();
    int[] a = new int[]{1, 2, 3, 4};
    assertFalse(solution.containsDuplicate(a));
  }

}