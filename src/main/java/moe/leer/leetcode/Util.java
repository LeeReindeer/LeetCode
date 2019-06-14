package moe.leer.leetcode;

import java.util.List;

/**
 * @author leer
 * Created at 2/18/19 4:53 PM
 */
public class Util {

  public static void printArray(int[] a) {
    printArray(a, a.length);
  }

  public static void printArray(int[] a, int len) {
    for (int i = 0; i < len; i++) {
      System.out.printf("%d ", a[i]);
    }
    System.out.println();
  }

  public static int[] listToArray(List<Integer> list) {
    if (list == null)
      return null;
    int[] array = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      array[i] = list.get(i);
    }
    return array;
  }
}
