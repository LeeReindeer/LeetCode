package moe.leer.leetcode.p572;

import moe.leer.leetcode.TreeNode;
import moe.leer.leetcode.Util;

import static org.junit.Assert.*;

/**
 * @author leer
 * Created at 19-6-19 下午4:47
 */
public class Test {

  @org.junit.Test
  public void isSubtree() {
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
    assertFalse(solution.isSubtree(root, root1));
    assertFalse(solution.isSubtree3(root, root1));
    assertTrue(solution.isSubtree2(root, root1));
  }
}