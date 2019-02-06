package moe.leer.leetcode.p685;

/**
 * @author leer Created at 2/3/19 9:33 PM
 */
@SuppressWarnings("Duplicates")
public class Solution {

  private int[] parent;

  private int find(int i) {
    while (i != parent[i]) {
      parent[i] = parent[parent[i]];
      i = parent[i];
    }
    return i;
  }

  public int[] findRedundantDirectedConnection(int[][] edges) {
    parent = new int[edges.length + 1];
    for (int i = 0; i <= edges.length; i++) parent[i] = i;

    int[] ans1 = null;
    int[] ans2 = null;
    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];
      int root1 = find(u);
      int root2 = find(v);
      if (root1 != root2) {
        if (root2 != v) { // has unioned
          ans1 = edge; // two parents
        } else {
          // union, same as parent[v] = root1, just a path compress
          parent[root2] = root1;
        }
      } else { // cycle
        ans2 = edge;
      }
    }

    if (ans1 == null)
      return ans2;
    if (ans2 == null)
      return ans1;

    // if has both two parents and cycle or neither, pick the first two parents edge
    for (int[] edge : edges) {
      if (edge[1] == ans1[1])
        return edge;
    }

    throw new IllegalStateException();
  }
}
