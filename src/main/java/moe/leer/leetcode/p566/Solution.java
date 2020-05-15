package moe.leer.leetcode.p566;

/**
 * 566. Reshape the Matrix Easy
 * <p>
 * You're given a matrix represented by a two-dimensional array,
 * and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
 *
 * @author leer
 * Created at 5/15/20 12:32 PM
 */
public class Solution {
  public int[][] matrixReshape(int[][] nums, int r, int c) {
    int m = nums.length;
    int n = nums[0].length;
    if (m * n != r * c) return nums;
    int[][] reshaped = new int[r][c];

    int index = 0; // 1-d array index
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        reshaped[i][j] = nums[index / n][index % n];
        index++;
      }
    }
    return reshaped;
  }
}
