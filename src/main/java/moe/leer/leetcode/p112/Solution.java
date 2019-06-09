package moe.leer.leetcode.p112;

import moe.leer.leetcode.TreeNode;

/**
 * @author leer
 * Created at 6/9/19 8:05 PM
 * <p>
 * <p>
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given the below binary tree and sum = 22,
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class Solution {
  // dfs the tree, subtract node value from sum, check whether leaf node equals the remain sum.
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) return false;
    // a leaf node
    if (root.left == null && root.right == null) return root.val == sum;
    return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
  }

  private int sum;

  public boolean hasPathSum2(TreeNode root, int sum) {
    this.sum = sum;
    return dfs(root, 0);
  }

  private boolean dfs(TreeNode root, int cur) {
    if (root == null) return false;
    if (root.left == null && root.right == null) {
      return this.sum == (cur + root.val);
    }
    return dfs(root.left, cur + root.val) || dfs(root.right, cur + root.val);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    TreeNode root = new TreeNode(5);
    TreeNode node1 = new TreeNode(4);
    TreeNode node2 = new TreeNode(8);
    TreeNode node3 = new TreeNode(11);
    TreeNode node4 = new TreeNode(13);
    TreeNode node5 = new TreeNode(4);
    TreeNode node6 = new TreeNode(7);
    TreeNode node7 = new TreeNode(2);
    TreeNode node8 = new TreeNode(1);
    root.left = node1;
    root.right = node2;
    node1.left = node3;
    node3.left = node6;
    node3.right = node7;
    node2.left = node4;
    node2.right = node5;
    node5.right = node8;
    System.out.println(solution.hasPathSum(root, 22));
    System.out.println(solution.hasPathSum2(root, 22));
  }
}
