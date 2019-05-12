package moe.leer.leetcode.p237;

import moe.leer.leetcode.ListNode;

/**
 * @author leer
 * Created at 5/12/19 2:52 PM
 */
public class Solution {
  public void deleteNode(ListNode node) {
    if (node == null) return;
    node.val = node.next.val;
    node.next = node.next.next;
  }
}
