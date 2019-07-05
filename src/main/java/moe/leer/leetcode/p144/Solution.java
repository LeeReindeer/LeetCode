package moe.leer.leetcode.p144;

import moe.leer.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author leer
 * Created at 7/5/19 11:25 AM
 */
public class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) return list;
    helper(root, list);
    return list;
  }

  private void helper(TreeNode root, List<Integer> list) {
    if (root == null) return;
    list.add(root.val);
    helper(root.left, list);
    helper(root.right, list);
  }

  public List<Integer> preorderTraversalIteration(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) return list;
    Stack<TreeNode> stack = new Stack<>();
    stack.add(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      list.add(node.val);
      if (node.right != null) // push right then left, so we'll travel left first
        stack.add(node.right);
      if (node.left != null)
        stack.add(node.left);
    }
    return list;
  }
}
