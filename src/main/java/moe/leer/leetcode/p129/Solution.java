package moe.leer.leetcode.p129;

import moe.leer.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leer
 * Created at 7/6/19 10:32 AM
 * <p>
 * Backtracking
 */
public class Solution {
  int sum;

  public int sumNumbers(TreeNode root) {
    if (root == null) return 0;
    backtrack(root, new ArrayList<>());
    return sum;
  }

  private void backtrack(TreeNode root, List<Integer> list) {
    if (root == null) return;
    list.add(root.val);
    if (root.left == null && root.right == null) {
      int s = 0;
      for (int i : list) {
        s *= 10;
        s += i;
      }
      sum += s;
    }
    backtrack(root.left, list);
    backtrack(root.right, list);
    list.remove(list.size() - 1);
  }


  public int sumNumbers2(TreeNode root) {
    return preorder(root, 0);
  }

  // with perorder DFS, we do not need to save the path to left node, just sum step by setp
  private int preorder(TreeNode root, int s) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) // leaf node
      return 10 * s + root.val;
    int sum = 0;
    int next = 10 * s + root.val;
    sum += preorder(root.left, next);
    sum += preorder(root.right, next);
    return sum;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    root.left = node2;
    root.right = node3;
    Solution solution = new Solution();
    System.out.println(solution.sumNumbers(root));
    System.out.println(solution.sumNumbers2(root));
  }
}
