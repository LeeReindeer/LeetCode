package moe.leer.leetcode.p100;

import moe.leer.leetcode.TreeNode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author leer
 * Created at 6/10/19 8:09 PM
 */
public class Test {

  @org.junit.Test
  public void isSameTree() {
    Solution solution = new Solution();
    TreeNode root1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    root1.left = node2;
    root1.right = node3;
    TreeNode root2 = new TreeNode(1);
    root2.left = node2;
    root2.right = node3;
    TreeNode root3 = new TreeNode(1);
    TreeNode root4 = new TreeNode(1);
    root4.left = node3;
    root4.right = node2;
    assertTrue(solution.isSameTree(root1, root2));
    assertFalse(solution.isSameTree(root1, root3));
    assertFalse(solution.isSameTree(root1, root4));
  }
}