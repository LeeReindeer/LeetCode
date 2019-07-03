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
  private static final TreeNode NULL_NODE = new TreeNode(Integer.MIN_VALUE);

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
      if (node.val != NULL_NODE.val) sb.append(node.val).append(" ");
      else sb.append("NULL ");
      if (node.left != null)
        q.offer(node.left);
      if (node.right != null)
        q.offer(node.right);
      // }
    }
    sb.append("]");
    System.out.println(sb.toString());
  }

  //@formatter:off
  /**
   * Build binary tree(not a BST) from level order
   *
   * @param levelOrder null node is presents in the array
   * Input: [5,1,4,null,null,3,6], will build tree:
   *     5
   *    / \
   *   1   4
   *      / \
   *     3   6
   */
  //@formatter:on
  public static TreeNode buildTree(Integer[] levelOrder) {
    if (levelOrder.length == 0) return null;
    TreeNode root = null;
    Queue<TreeNode> q = new LinkedList<>();
    for (Integer i : levelOrder) {
      root = fromLevelOrder(root, i, q);
    }
    q.clear();
    // replace the NULL_NODE mark node to null
    q.offer(root);
    while (!q.isEmpty()) {
      TreeNode node = q.poll();
      if (node.left != null) {
        if (node.left.val == NULL_NODE.val) node.left = null;
        else q.add(node.left);
      }
      if (node.right != null) {
        if (node.right.val == NULL_NODE.val) node.right = null;
        else q.add(node.right);
      }
    }
    return root;
  }

  /**
   * When a new node is created, add it to queue.
   * When a node 's left and right child is filled, remove it from queue
   */
  private static TreeNode fromLevelOrder(TreeNode root, Integer val, Queue<TreeNode> q) {
    TreeNode newNode;
    if (val != null) newNode = new TreeNode(val);
    else newNode = NULL_NODE;
    if (root == null) {
      root = newNode;
    } else if (q.peek() != null) {
      TreeNode node = q.peek();
      if (node.left == null) {
        node.left = newNode;
      } else if (node.right == null) {
        node.right = newNode;
        q.poll();
      }
    }
    if (val != null) {
      q.offer(newNode);
    }
    return root;
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
