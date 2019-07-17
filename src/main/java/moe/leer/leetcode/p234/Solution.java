package moe.leer.leetcode.p234;

import moe.leer.leetcode.ListNode;

/**
 * @author leer
 * Created at 7/17/19 2:24 PM
 */
public class Solution {
  public boolean isPalindrome(ListNode head) {
    ListNode fast = head, slow = head;
    while(fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    if(fast != null) slow = slow.next;
    slow = reverse(slow);
    fast = head;
    while(slow != null) {
      if (fast.val != slow.val) {
        return false;
      }
      fast = fast.next;
      slow = slow.next;
    }
    return true;
  }

  private ListNode reverse(ListNode head) {
    ListNode prev = null;
    while(head != null) {
      ListNode savedNext = head.next;
      head.next = prev;
      prev = head;
      head = savedNext;
    }
    return prev;
  }
}
