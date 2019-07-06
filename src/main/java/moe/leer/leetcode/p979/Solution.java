package moe.leer.leetcode.p979;

import moe.leer.leetcode.TreeNode;

/**
 * @author leer
 * Created at 7/6/19 1:08 PM
 */
public class Solution {
  int ans;

  public int distributeCoins(TreeNode root) {
    dfs(root);
    return ans;
  }

  private int dfs(TreeNode root) {
    if (root == null) return 0;
    int l = dfs(root.left);
    int r = dfs(root.right);
    ans += Math.abs(l) + Math.abs(r);
    return root.val + l + r - 1;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    TreeNode node1 = new TreeNode(0);
    TreeNode node2 = new TreeNode(0);
    root.left = node1;
    root.right = node2;
    Solution solution = new Solution();
    System.out.println(solution.distributeCoins(root));
  }
}
