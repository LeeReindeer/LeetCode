package moe.leer.leetcode.p001;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author leer
 * Created at 1/27/19 6:47 PM
 */
public class Test {

  @org.junit.Test
  public void testTwoSum() {
    moe.leer.leetcode.p001.Solution solution = new Solution();
    assertArrayEquals(new int[]{1, 2}, solution.twoSum(new int[]{3, 2, 4}, 6));
    assertArrayEquals(new int[]{0, 1}, solution.twoSum(new int[]{2, 7, 11, 15}, 9));
  }

  @org.junit.Test
  public void testTwoSumOnePass() {
    moe.leer.leetcode.p001.Solution solution = new Solution();
    assertArrayEquals(new int[]{1, 2}, solution.twoSumOnePass(new int[]{3, 2, 4}, 6));
    assertArrayEquals(new int[]{0, 1}, solution.twoSumOnePass(new int[]{2, 7, 11, 15}, 9));
  }
}
