package moe.leer.leetcode.p141;

import moe.leer.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author leer
 * Created at 1/10/20 2:34 PM
 * <p>
 * 141. Linked List Cycle
 * <p>
 * Two Pointer
 */
public class Solution {
  //Time: O(n), Space: O(n)
  public boolean hasCycle(ListNode head) {
    ListNode p = head;
    Set<ListNode> nodeSet = new HashSet<>();
    while (p != null) {
      if (nodeSet.contains(p)) {
        return true;
      }
      nodeSet.add(p);
      p = p.next;
    }
    return false;
  }

  //Time: O(n), Space: O(1)
  public boolean hasCycle2(ListNode head) {
    ListNode slow = head, fast = head;
    while (slow != null && fast != null) {
      if (fast.next == slow) { // fast node catch up slow node
        return true;
      }
      slow = slow.next;
      fast = fast.next;
      if (fast != null) {
        fast = fast.next;
      }
    }
    return false;
  }
}