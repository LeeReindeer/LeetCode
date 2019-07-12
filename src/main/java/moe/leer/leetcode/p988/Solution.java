package moe.leer.leetcode.p988;

import moe.leer.leetcode.TreeNode;

/**
 * @author leer
 * Created at 7/11/19 8:26 PM
 * <p>
 * 988. Smallest String Starting From Leaf
 * <p>
 * Given the root of a binary tree, each node has a value from 0 to 25 representing the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.
 * <p>
 * Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
 * <p>
 * (As a reminder, any shorter prefix of a string is lexicographically smaller: for example, "ab" is lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)
 * <p>
 * Backtracking
 * We travel the tree from root to leaf, store path in a stack(or something identical).
 * When reach leaf node, we record the smallest string path.
 */
public class Solution {

  private String smallest;

  public String smallestFromLeaf(TreeNode root) {
    if (root == null) return "";
    backtracking(root, new StringBuilder());
    return smallest;
  }

  private void backtracking(TreeNode root, StringBuilder sb) {
    if (root == null) return;
    if (root.left == null && root.right == null) {
      sb.append((char) (root.val + 'a'));
      String current = sb.reverse().toString();
      // we need to reverse it back!
      sb.reverse();
      if (smallest == null) smallest = current;
      if (smallest.compareTo(current) > 0) smallest = current;
      sb.deleteCharAt(sb.length() - 1);
    } else {
      sb.append((char) (root.val + 'a'));
      backtracking(root.left, sb);
      backtracking(root.right, sb);
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  public static void main(String[] args) {
//    TreeNode root = TreeNode.buildTree(new Integer[]{0, 1, 2, 3, 4, 3, 4});
    TreeNode root = TreeNode.buildTree(new Integer[]{25, 1, 3, 1, 3, 0, 2});
    Solution solution = new Solution();
    System.out.println(solution.smallestFromLeaf(root));
  }
}
