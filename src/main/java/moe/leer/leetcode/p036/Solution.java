package moe.leer.leetcode.p036;

import java.util.HashSet;

/**
 * @author leer
 * Created at 2/20/19 4:10 PM
 */
public class Solution {

  public boolean isValidSudoku(char[][] board) {
    // valid row and col
    for (int i = 0; i < 9; i++) {
      HashSet<Character> rowMap = new HashSet<>();
      HashSet<Character> colMap = new HashSet<>();
      for (int j = 0; j < 9; j++) {
        boolean isRowContains = rowMap.contains(board[i][j]);
        boolean isColContains = colMap.contains(board[j][i]);
        if (isRowContains || isColContains) {
          return false;
        } else {
          if (Character.isDigit(board[i][j])) {
            rowMap.add(board[i][j]);
          }
          if (Character.isDigit(board[j][i])) {
            colMap.add(board[j][i]);
          }
        }
      }
    }

    int[][] starter = new int[][]{
        {0, 0}, {0, 3}, {0, 6},
        {3, 0}, {3, 3}, {3, 6},
        {6, 0}, {6, 3}, {6, 6},
    };
    // check 3×3 sub-boxes
    for (int i = 0; i < 9; i++) {
      int[] startIndex = starter[i];
      HashSet<Character> map = new HashSet<>();
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          char ch = board[startIndex[0] + j][startIndex[1] + k];
          boolean isContains = map.contains(ch);
          if (isContains) {
            return false;
          } else {
            if (Character.isDigit(ch)) {
              map.add(ch);
            }
          }
        }
      }
    }
    return true;
  }

  public boolean isValidSudokuOnPass(char[][] board) {
    for (int i = 0; i < 9; i++) {
      HashSet<Character> rowMap = new HashSet<>();
      HashSet<Character> colMap = new HashSet<>();
      HashSet<Character> boxMap = new HashSet<>();
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.' && !rowMap.add(board[i][j])) {
          return false;
        }
        if (board[j][i] != '.' && !colMap.add(board[j][i])) {
          return false;
        }
        // 9 boxes
        int rowIndex = 3 * (i / 3);
        int colIndex = 3 * (i % 3);
        // index one row to 2d box
        char ch = board[rowIndex + j / 3][colIndex + j % 3];
        if (board[i][j] != '.' && !boxMap.add(ch)) {
          return false;
        }
      }
    }
    return true;
  }
}
