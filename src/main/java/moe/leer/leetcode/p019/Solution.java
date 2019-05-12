package moe.leer.leetcode.p019;

import moe.leer.leetcode.ListNode;

/**
 * @author leer
 * Created at 5/12/19 3:09 PM
 */
public class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode p = head;
    int cnt = 0;
    while (p != null) {
      p = p.next;
      cnt++;
    }
    int index = 0;
    int target = cnt - n;
    // remove head
    if (target == 0) {
      head = head.next;
      return head;
    }
    ListNode prev = head;
    p = head;
    while (p != null) {
      if (index++ == target) break;
      prev = p;
      p = p.next;
    }
    prev.next = p.next;
    return head;
  }

  // two pointer with dummy node
  public ListNode removeNthFromEnd2(ListNode head, int n) {

    ListNode start = new ListNode(0);
    ListNode slow = start, fast = start;
    slow.next = head;

    //Move fast in front so that the gap between slow and fast becomes n
    for (int i = 1; i <= n + 1; i++) {
      fast = fast.next;
    }
    //Move fast to the end, maintaining the gap
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }
    //Skip the desired node
    slow.next = slow.next.next;
    return start.next;
  }

}
