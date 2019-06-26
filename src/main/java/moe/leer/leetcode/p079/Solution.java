package moe.leer.leetcode.p079;

/**
 * @author leer
 * Created at 6/26/19 3:38 PM
 * <p>
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 */
public class Solution {

  private int rows, cols;
  private char[][] board;
  private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  /**
   * @see moe.leer.leetcode.p695.Solution#maxAreaOfIsland(int[][])
   * offer problem 12
   */
  public boolean exist(char[][] board, String word) {
    if (board == null || board.length == 0) return false;
    this.board = board;
    rows = board.length;
    cols = board[0].length;
    boolean[][] visited = new boolean[rows][cols];
    char[] wordChars = word.toCharArray();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (helper(i, j, wordChars, 0, visited)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean helper(int row, int col, char[] word, int currPathLen, boolean[][] visited) {
    if (currPathLen == word.length) return true;
    boolean hasPath = false;
    if (row >= 0 && row < rows && col >= 0 && col < cols
        && word[currPathLen] == board[row][col]
        && !visited[row][col]) {
      currPathLen++;
      visited[row][col] = true;
      for (int[] dir : dirs) {
        if (helper(row + dir[0], col + dir[1], word, currPathLen, visited)) {
          hasPath = true;
          break;
        }
      }
      if (!hasPath) {
        currPathLen--;
        visited[row][col] = false;
      }
    }
    return hasPath;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    char[][] matrix = new char[][]{
        {'a', 'b', 't', 'g'},
        {'c', 'f', 'c', 's'},
        {'j', 'd', 'e', 'h'}};
    System.out.println(solution.exist(matrix, "bfce"));
    System.out.println(solution.exist(matrix, "abfb"));
  }
}
