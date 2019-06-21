package moe.leer.leetcode.p113;

import moe.leer.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author leer
 * Created at 6/21/19 1:16 PM
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * <p>
 * Backtracing
 */
public class Solution {
  private List<List<Integer>> ans = new LinkedList<>();
  private int sum;

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    this.sum = sum;
    dfs(root, 0);
    return ans;
  }

  LinkedList<Integer> path = new LinkedList<>();

  private void dfs(TreeNode root, int cur) {
    if (root == null) return;
    path.addLast(root.val);
    if (root.left == null && root.right == null
        && this.sum == (cur + root.val)) {
      ans.add(new ArrayList<>(path));
    }
    dfs(root.left, cur + root.val);
    dfs(root.right, cur + root.val);
    path.removeLast();
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
    node5.left = new TreeNode(5);
    List<List<Integer>> ans = solution.pathSum(root, 22);
    for (List<Integer> path : ans) {
      System.out.println(path.toString());
    }
  }
}
