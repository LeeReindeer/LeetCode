package moe.leer.leetcode.p130;

/**
 * @author leer
 * Created at 1/28/19 8:04 PM
 */
public class Solution {

  private char[][] b;
  private int row;
  private int col;

  static class UF {
    private int[] parent;

    public UF(int size) {
      this.parent = new int[size];
      for (int i = 0; i < size; i++) {
        parent[i] = i;
      }
    }

    public int find(int id) {
//      while (id != parent[id]) {
//        parent[id] = parent[parent[id]];
//        id = parent[id];
//      }
      if (parent[id] == id) return id; //root
      return parent[id] = find(parent[id]);
//      return id;
    }

    public boolean connected(int p, int q) {
      return find(p) == find(q);
    }

    public void union(int p, int q) {
      // give p and q the same root
      int rp = find(p);
      int rq = find(q);
      if (rp == rq) return;

      parent[rp] = rq;
    }
  }

  public void solve(char[][] board) {
    row = board.length;
    if (row == 0) return;
    col = board[0].length;
    b = board;

    UF uf = new UF(row * col + 1);

    int border = row * col;

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        int id = xyTo1d(i, j);
        if ((i == 0 || j == 0 || i == row - 1 || j == col - 1) && b[i][j] == 'O') {
          uf.union(id, border);
        } else if (b[i][j] == 'O') {
          if (i < row - 1 && b[i + 1][j] == 'O') uf.union(id, id + col);
          if (b[i - 1][j] == 'O') uf.union(id, id - col);
          if (j < col - 1 && b[i][j + 1] == 'O') uf.union(id, id + 1);
          if (b[i][j - 1] == 'O') uf.union(id, id - 1);
        }
      }
    }

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        int id = xyTo1d(i, j);
        if (!uf.connected(id, border)) {
          b[i][j] = 'X';
        }
      }
    }
  }

  private int xyTo1d(int x, int y) {
    return x * col + y;
  }

  private int[] oneDToXy(int x) {
    return new int[]{x / col, x % col};
  }
}
