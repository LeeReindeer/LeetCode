package moe.leer.leetcode.p206;

import static org.junit.Assert.*;
import moe.leer.leetcode.ListNode;

/**
 * @author leer
 * Created at 5/15/19 8:29 PM
 */
public class Test {

  @org.junit.Test
  public void reverseList() {
    ListNode head = new ListNode(1);
    ListNode p = head;
    for (int i = 2; i <= 5; i++) {
      p.next = new ListNode(i);
      p = p.next;
    }
    Solution solution = new Solution();
    head = solution.reverseList(head);
    ListNode.printLinkedList(head);
    head = solution.reverseList(head);
    ListNode.printLinkedList(head);
    head = solution.reverseList2(head);
    ListNode.printLinkedList(head);
  }
}