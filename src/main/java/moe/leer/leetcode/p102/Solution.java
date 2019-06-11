package moe.leer.leetcode.p102;

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
    while (!q.isEmpty()) {
      List<Integer> level = new LinkedList<>();
      // nodes count in next level
      int children = q.size();
      while (children-- > 0) {
        TreeNode node = q.poll();
        if (node.left != null) {
          q.add(node.left);
        }
        if (node.right != null) {
          q.add(node.right);
        }
        level.add(node.val);
      }
      if (level.size() != 0) ans.add(level);
    }
    return ans;
  }
}
