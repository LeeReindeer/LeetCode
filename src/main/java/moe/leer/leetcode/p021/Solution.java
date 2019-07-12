package moe.leer.leetcode.p021;

import moe.leer.leetcode.ListNode;

/**
 * @author leer
 * Created at 7/12/19 10:04 AM
 */
public class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    if (l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
  }
}
