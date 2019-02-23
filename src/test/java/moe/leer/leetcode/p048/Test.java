package moe.leer.leetcode.p048;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author leer
 * Created at 2/23/19 7:40 PM
 */
public class Test {

  @org.junit.Test
  public void testCase1() {
    Solution solution = new Solution();
    int[][] matrix = new int[][]{
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    int[][] matrix2 = new int[][]{
        {7, 4, 1},
        {8, 5, 2},
        {9, 6, 3}
    };
    solution.rotate(matrix);
    assertArrayEquals(matrix2, matrix);
  }

}