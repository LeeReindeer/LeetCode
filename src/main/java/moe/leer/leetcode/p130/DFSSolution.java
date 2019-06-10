package moe.leer.leetcode.p130;

/**
 * @author leer
 * Created at 6/10/19 8:47 PM
 * <p>
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * Surrounded regions shouldn’t be on the border,
 * which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
class DFSSolution {
  private char[][] board;
  // whether connect to border
  //private boolean[][] border;
  private int row, col;

  public void solve(char[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) return;
    row = board.length;
    col = board[0].length;
    this.board = board;
    //border = new boolean[row][col];
    // dfs the border
    for (int i = 0; i < col; i++) {
      dfs(0, i);
      dfs(row - 1, i);
    }
    for (int i = 0; i < row; i++) {
      dfs(i, 0);
      dfs(i, col - 1);
    }
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        // not on the boarder and not connected to border
        //if (!border[i][j] && board[i][j] == 'O') {
        if (board[i][j] == 'O') {
          board[i][j] = 'X';
        }
        if (board[i][j] == '1') {
          board[i][j] = 'O';
        }
      }
    }
  }

  private void dfs(int r, int c) {
    if (r < 0 || r >= row || c < 0 || c >= col || board[r][c] == 'X' || board[r][c] == '1') return;
    // mark 'O' connected to boarder to '1', so we don't need extra space
    board[r][c] = '1';
    dfs(r, c + 1);
    dfs(r, c - 1);
    dfs(r + 1, c);
    dfs(r - 1, c);
  }
}
