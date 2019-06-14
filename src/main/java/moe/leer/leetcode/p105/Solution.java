package moe.leer.leetcode.p105;

import moe.leer.leetcode.TreeNode;

/**
 * @author leer
 * Created at 6/14/19 9:32 AM
 * <p>
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 */
class Solution {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
    return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
  }

  private TreeNode helper(int[] preorder, int preStart, int preEnd,
                          int[] inorder, int inStart, int inEnd) {
    int rootVal = preorder[preStart];
    TreeNode root = new TreeNode(rootVal);
    if (preStart == preEnd && inStart == inEnd) {
      return root;
    }
    int inRootIndex = inStart;
    while (inRootIndex <= inEnd && inorder[inRootIndex] != rootVal) {
      inRootIndex++;
    }
    int leftLen = inRootIndex - inStart;
    int preLeftEnd = preStart + leftLen;
    if (leftLen > 0) {
      root.left = helper(preorder, preStart + 1, preLeftEnd, inorder, inStart, inRootIndex - 1);
    }
    if (preEnd - preStart > leftLen) {
      root.right = helper(preorder, preLeftEnd + 1, preEnd, inorder, inRootIndex + 1, inEnd);
    }
    return root;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] preorder = new int[]{3, 9, 20, 15, 7};
    int[] inorder = new int[]{9, 3, 15, 20, 7};
    TreeNode.printTree(solution.buildTree(preorder, inorder));
  }
}
