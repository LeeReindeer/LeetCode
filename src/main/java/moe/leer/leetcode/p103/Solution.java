package moe.leer.leetcode.p103;

import moe.leer.leetcode.TreeNode;

import java.util.*;


//@formatter:off
/**
 * @author leer
 * Created at 7/15/19 8:29 PM
 *
 * 103. Binary Tree Zigzag Level Order Traversal
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
//@formatter:on
public class Solution {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new LinkedList<>();
    if (root == null) return result;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    boolean flag = true;
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      List<Integer> level = new ArrayList<>(levelSize);
      while (levelSize-- > 0) {
        TreeNode node = queue.poll();
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
        level.add(node.val);
      }
      if (level.size() != 0) {
        if (flag) {
          result.add(level);
        } else {
          // from right to left order
          Collections.reverse(level);
          result.add(level);
        }
        flag = !flag;
      }
    }
    return result;
  }
}
