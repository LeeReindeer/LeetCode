package moe.leer.leetcode.p283;

import moe.leer.leetcode.TestUtil;
import org.junit.Assert;

/**
 * @author leer
 * Created at 2/20/19 3:32 PM
 */
public class Test {

  public static final int LEN = 100000;

  @org.junit.Test
  public void test1() {
    int[] a = TestUtil.generateIntArray(LEN, LEN);
    for (int i = 10000; i < a.length / 2; i++) {
      a[i] = 0;
    }
    Solution solution = new Solution();
    solution.moveZeroes(a);
    Assert.assertEquals(0, a[LEN - 1]);
  }

  @org.junit.Test
  public void test2() {
    int[] a = TestUtil.generateIntArray(LEN, LEN);
    for (int i = 10000; i < a.length / 2; i++) {
      a[i] = 0;
    }
    Solution solution = new Solution();
    solution.moveZeroes2(a);
    Assert.assertEquals(0, a[LEN - 1]);
  }
}