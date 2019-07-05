package moe.leer.leetcode.p094;

import moe.leer.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author leer
 * Created at 7/5/19 10:55 AM
 */
public class Solution {
  // use recursive
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) return list;
    helper(root, list);
    return list;
  }

  private void helper(TreeNode root, List<Integer> list) {
    if (root == null) return;
    helper(root.left, list);
    list.add(root.val);
    helper(root.right, list);
  }

  // use iteration and stack
  public List<Integer> inorderTraversalIteration(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) return list;
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    while (curr != null || !stack.isEmpty()) {
      // go left
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      // pop last curr node
      TreeNode node = stack.pop();
      list.add(node.val);
      // go right
      curr = node.right;
    }
    return list;
  }

}
