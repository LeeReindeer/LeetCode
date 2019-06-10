package moe.leer.leetcode.p100;

import moe.leer.leetcode.TreeNode;

/**
 * @author leer
 * Created at 6/10/19 7:57 PM
 */
class Solution {
  // DFS the tree, check every node's value is same
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if ((p == null && q != null) || (p != null && q == null) || p.val != q.val) return false;
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    TreeNode root1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    root1.left = node2;
    root1.right = node3;
    TreeNode root2 = new TreeNode(1);
    root2.left = node2;
    root2.right = node3;
    System.out.println(solution.isSameTree(root1, root2));
  }
}
