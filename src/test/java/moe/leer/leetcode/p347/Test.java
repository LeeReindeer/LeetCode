package moe.leer.leetcode.p347;

import java.util.Arrays;
import java.util.List;

/**
 * @author leer
 * Created at 5/23/19 4:56 PM
 */
public class Test {

  private int[] a = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6};
  private Solution solution = new Solution();

  @org.junit.Test
  public void topKFrequent1() {
    int[] a = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6};
    List<Integer> list = solution.topKFrequent1(a, 10);
    System.out.println(Arrays.toString(list.toArray()));
  }

  @org.junit.Test
  public void topKFrequent2() {
    List<Integer> list = solution.topKFrequent2(a, 10);
    System.out.println(Arrays.toString(list.toArray()));
  }

  @org.junit.Test
  public void topKFrequent3() {
    List<Integer> list = solution.topKFrequent3(a, 10);
    System.out.println(Arrays.toString(list.toArray()));
  }
}