package moe.leer.leetcode.p206;

import moe.leer.leetcode.ListNode;

/**
 * @author leer
 * Created at 5/15/19 8:25 PM
 */
public class Solution {
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode savedNext = head.next;
      head.next = prev;
      prev = head;
      head = savedNext;
    }
    return prev;
  }

  // recursive
  public ListNode reverseList2(ListNode head) {
    return recursive(head, null);
  }

  private ListNode recursive(ListNode head, ListNode prev) {
    if (head == null) return prev;
    ListNode savedNext = head.next;
    head.next = prev;
    return recursive(savedNext, head);
  }

}
