package moe.leer.leetcode.p102;

import moe.leer.leetcode.TreeNode;

import java.util.List;

/**
 * @author leer
 * Created at 6/11/19 5:46 PM
 */
public class Test {

  private void print(List<List<Integer>> ans) {
    for (List<Integer> list : ans) {
      for (int i : list) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }

  @org.junit.Test
  public void testCase1() {
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
    List<List<Integer>> ans = solution.levelOrder(root);
    print(ans);
  }

  @org.junit.Test
  public void testCase2() {
    Solution solution = new Solution();
    TreeNode root = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    root.left = node2;
    root.right = node3;
    node2.left = node4;
    node3.right = node5;
    List<List<Integer>> ans = solution.levelOrder(root);
    print(ans);
  }
}