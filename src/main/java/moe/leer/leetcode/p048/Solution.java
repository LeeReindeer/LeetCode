package moe.leer.leetcode.p048;

/**
 * @author leer
 * Created at 2/21/19 4:53 PM
 * <p>
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Note:
 * <p>
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * Example 1:
 * <p>
 * Given input matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * Example 2:
 * <p>
 * Given input matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */
public class Solution {

  /**
   * clockwise rotate
   * first reverse up to down, then swap the symmetry
   * 1 2 3     7 8 9     7 4 1
   * 4 5 6  => 4 5 6  => 8 5 2
   * 7 8 9     1 2 3     9 6 3
   * <p>
   * anticlockwise rotate
   * reverse left ro right, then swap the symmetry
   */
  public void rotate(int[][] matrix) {
    int n = matrix.length;
    if (n <= 1) return;
    // reverse matrix up to down
    for (int i = 0; i < n / 2; i++) {
      for (int j = 0; j < n; j++) {
        int t = matrix[i][j];
        matrix[i][j] = matrix[n - 1 - i][j];
        matrix[n - 1 - i][j] = t;
      }
    }
//    System.out.println(Arrays.deepToString(matrix));
    // swap the symmetry
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        if (i != j) {
          int t = matrix[i][j];
          matrix[i][j] = matrix[j][i];
          matrix[j][i] = t;
        }
      }
    }
//    System.out.println(Arrays.deepToString(matrix));
  }
}
