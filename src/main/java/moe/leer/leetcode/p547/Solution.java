package moe.leer.leetcode.p547;

/**
 * @author leer
 * Created at 1/31/19 8:45 PM
 */
public class Solution {

    static class WeightedUF {
        int[] parent;
        int[] sz;
        int cnt;

        public WeightedUF(int size) {
            this.parent = new int[size];
            this.sz = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                sz[i] = 1;
            }
            cnt = size;
        }

        public int getCnt() {
            return cnt;
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
            int i = find(p);
            int j = find(q);
            if (i == j) return;

            // make smaller root point to larger one
            if (sz[i] < sz[j]) {
                parent[i] = j;
            } else {
                parent[j] = i;
            }
            cnt--;
        }
    }

    public int findCircleNum(int[][] M) {
        int row = M.length;
        if (row == 0) return 0;
        int col = M[0].length;

        WeightedUF uf = new WeightedUF(row);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (M[i][j] == 1 && i != j) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCnt();
    }
}
