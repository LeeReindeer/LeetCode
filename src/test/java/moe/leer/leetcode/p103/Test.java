package moe.leer.leetcode.p103;

import moe.leer.leetcode.TreeNode;
import moe.leer.leetcode.Util;

import java.util.List;

/**
 * @author leer
 * Created at 7/15/19 8:46 PM
 */
public class Test {

  @org.junit.Test
  public void zigzagLevelOrder() {
    Solution solution = new Solution();
    TreeNode root = new TreeNode(3);
    TreeNode node1 = new TreeNode(9);
    TreeNode node2 = new TreeNode(20);
    TreeNode node3 = new TreeNode(15);
    TreeNode node4 = new TreeNode(7);
    root.left = node1;
    root.right = node2;
    node2.left = node3;
    node2.right = node4;
    List<List<Integer>> ans = solution.zigzagLevelOrder(root);
    Util.printListList(ans);
  }
}