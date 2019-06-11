package moe.leer.leetcode.P102;

import moe.leer.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author leer
 * Created at 6/11/19 5:21 PM
 */
class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) return ans;
    q.add(root);
    List<Integer> level1 = new LinkedList<>();
    level1.add(root.val);
    ans.add(level1);
    // nodes count in current level
    int children = 1;
    while (!q.isEmpty()) {
      List<Integer> level = new LinkedList<>();
      // nodes count in next level
      int next = 0;
      while (children-- > 0) {
        TreeNode node = q.poll();
        if (node.left != null) {
          q.add(node.left);
          next++;
          level.add(node.left.val);
        }
        if (node.right != null) {
          q.add(node.right);
          next++;
          level.add(node.right.val);
        }
      }
      children = next;
      if (level.size() != 0) ans.add(level);
    }
    return ans;
  }
}
