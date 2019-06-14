package moe.leer.leetcode.p104;

import moe.leer.leetcode.TreeNode;

/**
 * @author leer
 * Created at 6/14/19 9:16 AM
 * 104. Maximum Depth of Binary Tree
 */
class Solution {
  public int maxDepth(TreeNode root) {
    return dfs(root, 0);
  }

  private int dfs(TreeNode root, int level) {
    if (root == null) return level;
    level++;
    return Math.max(dfs(root.left, level), dfs(root.right, level));
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    TreeNode node1 = new TreeNode(9);
    TreeNode node2 = new TreeNode(20);
    TreeNode node3 = new TreeNode(15);
    TreeNode node4 = new TreeNode(7);
    root.left = node1;
    root.right = node2;
    node2.left = node3;
    node2.right = node4;
    System.out.println(new Solution().maxDepth(root));
  }
}
