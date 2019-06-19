package moe.leer.leetcode.p572;

import moe.leer.leetcode.TreeNode;
import moe.leer.leetcode.Util;

import java.util.Stack;

/**
 * @author leer
 * Created at 19-6-19 下午4:33
 * <p>
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants.
 * The tree s could also be considered as a subtree of itself.
 */
public class Solution {
  //t has exactly the same structure and node values with a subtree of s.
  public boolean isSubtree(TreeNode s, TreeNode t) {
    String spreorder = generatePreOrderString(s);
    String tpreorder = generatePreOrderString(t);
    return spreorder.contains(tpreorder);
  }

  // is s contain t
  public boolean isSubtree2(TreeNode s, TreeNode t) {
    String spreorder = generatePreOrderStringIgnoreNull(s);
    String tpreorder = generatePreOrderStringIgnoreNull(t);
    return spreorder.contains(tpreorder);
  }

  // compare tree nodes
  public boolean isSubtree3(TreeNode s, TreeNode t) {
    if (s == null) return false;
    if (isSame(s, t)) return true;
    return isSubtree3(s.left, t) || isSubtree3(s.right, t);
  }

  private boolean isSame(TreeNode s, TreeNode t) {
    if (s == null && t == null) return true;
    if (s == null || t == null) return false;
    if (s.val != t.val) return false;
    return isSame(s.left, t.left) && isSame(s.right, t.right);
  }

  private String generatePreOrderStringIgnoreNull(TreeNode s) {
    StringBuilder sb = new StringBuilder();
    Stack<TreeNode> stack = new Stack<>();
    stack.push(s);
    while (!stack.isEmpty()) {
      TreeNode root = stack.pop();
      if (root != null) {
        sb.append(",").append(root.val);
      }
      if (root != null) {
        stack.push(root.right);
        stack.push(root.left);
      }
    }
    return sb.toString();
  }

  private String generatePreOrderString(TreeNode s) {
    StringBuilder sb = new StringBuilder();
    Stack<TreeNode> stack = new Stack<>();
    stack.push(s);
    while (!stack.isEmpty()) {
      TreeNode root = stack.pop();
      if (root == null) {
        sb.append(",#"); // Appending # inorder to handle same values but not subtree cases
      } else {
        sb.append(",").append(root.val);
      }
      if (root != null) {
        stack.push(root.right);
        stack.push(root.left);
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node0 = new TreeNode(0);
    root.left = node4;
    root.right = node5;
    node4.left = node1;
    node4.right = node2;
    node2.left = node0;
    TreeNode root1 = new TreeNode(4);
    root1.left = new TreeNode(1);
    root1.right = new TreeNode(2);
    Solution solution = new Solution();
    System.out.println(solution.generatePreOrderStringIgnoreNull(root));
    Util.printArray(TreeNode.preOrder(root));
    System.out.println(solution.isSubtree(root, root1));
    System.out.println(solution.isSubtree2(root, root1));
  }
}
