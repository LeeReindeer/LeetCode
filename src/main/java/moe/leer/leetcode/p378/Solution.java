package moe.leer.leetcode.p378;

import java.util.Arrays;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 * <p>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * <p>
 * Example:
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * return 13.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 *
 * @author leer
 * Created at 9/10/19 9:39 PM
 */
public class Solution {

  private int[] merge(int[] a, int[] b) {
    int[] c = new int[a.length + b.length];
    int j = 0, k = 0;
    for (int i = 0; i < c.length; i++) {
      if (j >= a.length) c[i] = b[k++];
      else if (k >= b.length) c[i] = a[j++];
      else if (a[j] < b[k]) c[i] = a[j++];
      else c[i] = b[k++];
    }
    return c;
  }

  //time: O(n^2), space: O(n^2)
  public int kthSmallest2(int[][] matrix, int k) {
    int n = matrix.length;
    if (n == 1 && k == 1) return matrix[0][0];
    int[] array = null;
    for (int i = 0; i < matrix.length - 1; i++) {
      int[] a;
      if (array == null) {
        a = matrix[i];
      } else {
        a = array;
      }
      int[] b = matrix[i + 1];
      array = merge(a, b);
    }
    System.out.println(Arrays.toString(array));
    return array[k - 1];
  }

  // O(lg(n^2))
  // Binary search in **range** from matrix[0][0] to matrix[n-1][n-1]
  public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      int count = 0, j = n - 1;
      // for each row, we r going to find nums < mid
      for (int i = 0; i < n; i++) {
        while (j >= 0 && matrix[i][j] > mid) j--;
        count += (j + 1); // count nums <= mid
      }
      // adjust search range
      if (count < k) {
        // make next mid greater, so count nums <= mid will increase util it be k
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }
    return lo;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] matrix = new int[][]{
        {1, 5, 9},
        {10, 11, 13},
        {12, 13, 15}
    };
    System.out.println(solution.kthSmallest(matrix, 8));
  }
}
