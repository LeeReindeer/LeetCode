package moe.leer.leetcode.p189;

import org.junit.Before;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * @author leer
 * Created at 2/13/19 9:48 PM
 */
public class Test {

  @org.junit.Test
  public void testRotate() {
    int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
    moe.leer.leetcode.p189.Solution solution = new Solution();
    solution.rotate(a, 3);
    assertEquals(5, a[0]);
  }

  @org.junit.Test
  public void testRotate2() {
    int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
    moe.leer.leetcode.p189.Solution solution = new Solution();
    solution.rotate2(a, 3);
    assertEquals(5, a[0]);
  }
  private final int LEN = 100000;

  int bigArray1[] = new int[LEN];
  int bigArray2[] = new int[LEN];

  @Before
  public void init() {
    Random random1 = new Random();
    Random random2 = new Random();
    for (int i = 0; i < LEN; i++) {
      bigArray1[i] = random1.nextInt(LEN);
      bigArray2[i] = random2.nextInt(LEN);
    }
  }


  // O(k*LEN)
  @org.junit.Test
  public void timeTest1() {
    moe.leer.leetcode.p189.Solution solution = new Solution();
    solution.rotate(bigArray2, 10000);
  }

  // O(LEN)
  @org.junit.Test
  public void timeTest2() {
    moe.leer.leetcode.p189.Solution solution = new Solution();
    solution.rotate2(bigArray1, 10000);
  }

}