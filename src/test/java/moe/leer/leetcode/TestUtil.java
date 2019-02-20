package moe.leer.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * @author leer
 * Created at 1/28/19 8:39 PM
 */
public class TestUtil {
  public static char[][] int2char(int[][] g, int row, int col) {
    char[][] chars = new char[row][col];
    if (row == 0) {
      return chars;
    }
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        chars[i][j] = (char) (g[i][j] + '0');
      }
    }
    return chars;
  }

  /**
   * 1d or 1d array to pretty string
   */
  public static String prettyDeepToString(Object[] objects) {
    String s = Arrays.deepToString(objects);
    if (!s.contains("],")) return s;
    StringBuilder sb = new StringBuilder();
    char[] chars = s.toCharArray();
    for (int i = 0; i < s.length() - 1; i++) {
      sb.append(chars[i]);
      if (chars[i] == ']' && chars[i + 1] == ',') {
        sb.append(',');
        i++;
        sb.append("\n");
      }
    }
    sb.append(']');
    return sb.toString();
  }

  public static void printArray(int[] a, int len) {
    for (int i = 0; i < len; i++) {
      System.out.printf("%d ", a[i]);
    }
    System.out.println();
  }

  public static void swap(Comparable[] a, int i, int j) {
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  /**
   * Generate an int array with length [size], every element is in 0 ~ range - 1.
   *
   * @param size  size of array
   * @param range top range of array element
   * @return the generated array
   */
  public static int[] generateIntArray(int size, int range) {
    Random random = new Random();
    int[] res = new int[size];
    for (int i = 0; i < res.length; i++) {
      res[i] = random.nextInt(range);
    }
    return res;
  }


  /**
   * Is array sort in ascending order
   *
   * @param a the array
   * @return whether soted in ascending order
   */
  public static boolean isSorted(Comparable[] a) {
    for (int i = 0; i < a.length - 1; i++) {
      if (a[i].compareTo(a[i + 1]) > 0) return false;
    }
    return true;
  }

  public static void shuffleArray(Comparable[] a) {
    Random random = new Random();
    int len = a.length;
    for (int i = 0; i < len; i++) {
      swap(a, random.nextInt(len), random.nextInt(len));
    }
  }
}
