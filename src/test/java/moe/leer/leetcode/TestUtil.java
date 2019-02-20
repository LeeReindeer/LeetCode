package moe.leer.leetcode;

import java.util.Arrays;

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
}
