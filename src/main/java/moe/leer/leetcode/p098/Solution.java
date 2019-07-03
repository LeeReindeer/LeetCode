package moe.leer.leetcode.p098;

import moe.leer.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leer
 * Created at 7/3/19 11:43 AM
 * <p>
 * 98. Validate Binary Search Tree
 * <p>
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 */
public class Solution {

  public boolean isValidBST(TreeNode root) {
    if (root == null) return false;
    return helper(root, null, null);
  }

  private boolean helper(TreeNode root, Integer lower, Integer upper) {
    if (root == null) return true;
    boolean leftValid, rightValid;
    if (lower != null && root.val <= lower) return false;
    if (upper != null && root.val >= upper) return false;
    leftValid = helper(root.left, lower, root.val); // left child < root
    rightValid = helper(root.right, root.val, upper); // right child > root
    return leftValid && rightValid;
  }

  /**
   * Use inorder travel, valid the array is sorted
   */
  public boolean isValidBST2(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    inorder(root, list);
    for (int i = 1; i < list.size(); i++) {
      if (list.get(i) <= list.get(i - 1)) {
        return false;
      }
    }
    return true;
  }

  private void inorder(TreeNode root, List<Integer> list) {
    if (root == null) return;
    inorder(root.left, list);
    list.add(root.val);
    inorder(root.right, list);
  }


  public static void main(String[] args) {
    Solution solution = new Solution();
    TreeNode root = TreeNode.buildTree(new Integer[]{10, 5, 15, null, null, 6, 20});
    System.out.println(solution.isValidBST(root));
    root = TreeNode.buildTree(new Integer[]{2, 1, 3});
    System.out.println(solution.isValidBST(root));
  }
}
