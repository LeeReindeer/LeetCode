package moe.leer.leetcode.p144;

import moe.leer.leetcode.TreeNode;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * @author leer
 * Created at 7/5/19 11:29 AM
 */
public class Test {

  TreeNode root;

  @Before
  public void initTree() {
    root = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    root.right = node2;
    root.left = node4;
    node2.left = node3;
  }

  @org.junit.Test
  public void preorderTraversal() {
    Solution solution = new Solution();
    System.out.println(solution.preorderTraversal(root));
  }

  @org.junit.Test
  public void preorderTraversalIteration() {
    Solution solution = new Solution();
    System.out.println(solution.preorderTraversalIteration(root));
  }
}