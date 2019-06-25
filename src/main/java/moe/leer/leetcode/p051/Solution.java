package moe.leer.leetcode.p051;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leer
 * Created at 6/24/19 7:28 PM
 * <p>
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 */
public class Solution {
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> res = new ArrayList<>();
    String[] queens = new String[n];
    char[] initial = new char[n];
    Arrays.fill(initial, '.');
    Arrays.fill(queens, new String(initial));
    solveNQueens(res, queens, 0, n);
    return res;
  }

  private void solveNQueens(List<List<String>> res, String[] queens, int row, int n) {
    if (row == n) {
      res.add(new ArrayList<>(Arrays.asList(queens)));
      return;
    }
    // check evey column of current row
    for (int col = 0; col < n; col++) {
      if (isValid(queens, row, col, n)) {
        char[] chars = queens[row].toCharArray();
        chars[col] = 'Q';
        queens[row] = String.valueOf(chars);
        solveNQueens(res, queens, row + 1, n); // next row
        chars[col] = '.';
        queens[row] = String.valueOf(chars);
      }
    }
  }

  private boolean isValid(String[] queens, int row, int col, int n) {
    // check if the column had a queen before
    for (int i = 0; i < row; i++) {
      if (queens[i].toCharArray()[col] == 'Q') return false;
    }
    //check if the left-up diagonal had a queen before.
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j) {
      if (queens[i].toCharArray()[j] == 'Q') return false;
    }
    //check if the right-up diagonal had a queen before.
    for (int i = row - 1, j = col + 1; i >= 0 && j < n; --i, ++j) {
      if (queens[i].toCharArray()[j] == 'Q') return false;
    }
    return true;
  }

  public static void main(String[] args) {
    List<List<String>> anss = new Solution().solveNQueens(4);
    System.out.println(anss.size());
    for (List<String> ans : anss) {
      for (String row : ans) {
        System.out.println(row);
      }
      System.out.println();
    }
  }
}
