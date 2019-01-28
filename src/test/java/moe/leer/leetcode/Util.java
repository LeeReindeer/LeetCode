package moe.leer.leetcode;

/**
 * @author leer
 * Created at 1/28/19 8:39 PM
 */
public class Util {
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
}
