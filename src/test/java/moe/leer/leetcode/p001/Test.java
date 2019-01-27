package moe.leer.leetcode.p001;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author leer
 * Created at 1/27/19 6:47 PM
 */
public class Test {

  @org.junit.Test
  public void testTwoSum() {
    moe.leer.leetcode.p001.Solution solution = new Solution();
    assertEquals(
        Arrays.toString(solution.twoSum(new int[]{3, 2, 4}, 6)),
        Arrays.toString(new int[]{1, 2})
    );

    assertEquals(
        Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)),
        Arrays.toString(new int[]{0, 1})
    );
  }
}
