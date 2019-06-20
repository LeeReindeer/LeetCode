package moe.leer.leetcode.p101;

import moe.leer.leetcode.TreeNode;

/**
 * @author leer
 * Created at 6/20/19 11:34 AM
 * 101. Symmetric Tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 */
public class Solution {

  public boolean isSymmetric(TreeNode root) {
    return root == null || isSymmetric(root, root);
  }

  // left subtree equals right subtree
  private boolean isSymmetric(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) return true;
    if (root1 == null || root2 == null) return false;
    return root1.val == root2.val
        && isSymmetric(root1.left, root2.right)
        && isSymmetric(root1.right, root2.left);
  }
}
