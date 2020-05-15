package moe.leer.leetcode.p530;

import moe.leer.leetcode.TreeNode;

/**
 * @author leer
 * Created at 5/15/20 12:34 PM
 */
public class Solution {
  private int minDiff = Integer.MAX_VALUE;
  private TreeNode preNode = null;
  public int getMinimumDifference(TreeNode root) {
    inorder(root);
    return minDiff;
  }

  void inorder(TreeNode root) {
    if (root == null) return;
    inorder(root.left);

    if (preNode != null) {
      minDiff = Math.min(minDiff, root.val - preNode.val);
    }
    preNode = root;

    inorder(root.right);
  }
}
