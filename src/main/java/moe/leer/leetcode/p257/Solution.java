package moe.leer.leetcode.p257;

import moe.leer.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leer
 * Created at 6/22/19 10:21 PM
 */
public class Solution {
  List<String> ans = new ArrayList<>();

  public List<String> binaryTreePaths(TreeNode root) {
    if (root == null) {
      return ans;
    }
    dfs(root, String.valueOf(root.val));
    return ans;
  }

  private void dfs(TreeNode root, String temp) {
    if (root == null) return;
    if (root.left == null && root.right == null) {
      ans.add(temp);
    }
    if (root.left != null) {
      dfs(root.left, temp + "->" + root.left.val);
    }
    if (root.right != null) {
      dfs(root.right, temp + "->" + root.right.val);
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node5 = new TreeNode(5);
    root.left = node2;
    root.right = node3;
    node2.right = node5;
    System.out.println(new Solution().binaryTreePaths(root));
  }
}
