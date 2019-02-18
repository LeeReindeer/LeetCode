package moe.leer.leetcode;

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
}
