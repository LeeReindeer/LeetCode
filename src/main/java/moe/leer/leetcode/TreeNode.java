package moe.leer.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author leer
 * Created at 6/9/19 8:08 PM
 */
public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int x) {
    this.val = x;
  }

  public static int[] preOrder(TreeNode root) {
    ArrayList<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode p = root;
    while (p != null || !stack.isEmpty()) {
      while (p != null) {
        list.add(p.val);
        stack.push(p);
        p = p.left;
      }
      p = stack.pop();
      p = p.right;
    }
    int[] array = Util.listToArray(list);
    return array;
  }

  public static int[] inOrder(TreeNode root) {
    ArrayList<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode p = root;
    while (p != null || !stack.isEmpty()) {
      while (p != null) {
        stack.push(p);
        p = p.left;
      }
      p = stack.pop();
      list.add(p.val);
      p = p.right;
    }
    int[] array = Util.listToArray(list);
    return array;
  }

  /**
   * Print Binary tree in level order
   */
  public static void printTree(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    StringBuilder sb = new StringBuilder();
    sb.append("[ ");
    while (!q.isEmpty()) {
      TreeNode node = q.poll();
      // if (node == null) {
      // sb.append("null").append(" ");
      // } else {
      sb.append(node.val).append(" ");
      if (node.left != null)
        q.offer(node.left);
      if (node.right != null)
        q.offer(node.right);
      // }
    }
    sb.append("]\n");
    System.out.println(sb.toString());
  }

  @Override
  public String toString() {
    return "TreeNode{" +
        "val=" + val +
        ", left=" + left +
        ", right=" + right +
        '}';
  }
}
