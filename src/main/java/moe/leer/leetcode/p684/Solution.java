package moe.leer.leetcode.p684;

/**
 * @author leer
 * Created at 2/1/19 9:21 PM
 */
public class Solution {

  private int[] id;

  private int find(int x) {
    if (x == id[x]) return x;
    return id[x] = find(id[x]);
  }

  private void union(int p, int q) {
    int i = find(p);
    int j = find(q);
    id[i] = j;
  }

  public int[] findRedundantConnection(int[][] edges) {
    id = new int[edges.length + 1];
    for (int i = 0; i < edges.length; i++) {
      id[i] = i;
    }

    int[] ans = new int[2];

    for (int[] edge : edges) {
      int c1 = find(edge[0]);
      int c2 = find(edge[1]);
      if (c1 == c2) { // if node1 and node2 is in a component, link an edge will make a cycle
        ans[0] = edge[0];
        ans[1] = edge[1];
      }
      union(edge[0], edge[1]);
    }
    return ans;
  }
}
