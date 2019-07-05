package moe.leer.leetcode.p094;

import moe.leer.leetcode.TreeNode;
import org.junit.Before;

/**
 * @author leer
 * Created at 7/5/19 11:08 AM
 */
public class Test {

  TreeNode root;

  @Before
  public void initTree() {
    root = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    root.right = node2;
    node2.left = node3;
  }

  @org.junit.Test
  public void inorderTraversal() {
    Solution solution = new Solution();
    System.out.println(solution.inorderTraversal(root));
  }

  @org.junit.Test
  public void inorderTraversalIteration() {
    Solution solution = new Solution();
    System.out.println(solution.inorderTraversalIteration(root));
  }
}