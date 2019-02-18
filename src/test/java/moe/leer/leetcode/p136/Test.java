package moe.leer.leetcode.p136;

import static org.junit.Assert.assertEquals;

/**
 * @author leer
 * Created at 2/17/19 5:06 PM
 */
public class Test {

  @org.junit.Test
  public void testCase1() {
    moe.leer.leetcode.p136.Solution solution = new Solution();
    assertEquals(1, solution.singleNumber2(new int[]{2, 2, 1}));
  }

  @org.junit.Test
  public void testCase2() {
    moe.leer.leetcode.p136.Solution solution = new Solution();
    assertEquals(4, solution.singleNumber2(new int[]{4, 1, 2, 1, 2}));
  }

  @org.junit.Test
  public void testXOR() {
    moe.leer.leetcode.p136.Solution solution = new Solution();
    assertEquals(1, solution.singleNumber(new int[]{2, 2, 1}));
  }

}