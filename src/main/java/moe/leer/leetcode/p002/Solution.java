package moe.leer.leetcode.p002;

import moe.leer.leetcode.ListNode;

/**
 * @author leer
 * Created at 5/29/19 11:30 PM
 */
public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode prev = new ListNode(0);
    ListNode head = prev;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
      ListNode cur = new ListNode(0);
      int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
      cur.val = sum % 10;
      carry = sum / 10;
      prev.next = cur;
      prev = cur;

      l1 = (l1 == null) ? l1 : l1.next;
      l2 = (l2 == null) ? l2 : l2.next;
    }
    return head.next;
  }

  public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    ListNode prev = new ListNode(0), head;
    head = prev;
    int c = 0;
    while (l1 != null || l2 != null || c != 0) {
      ListNode cur = new ListNode(0);
      int sum = ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val) + c;
      cur.val = sum;
      c = sum >= 10 ? 1 : 0;
      if (sum >= 10) cur.val -= 10;
      prev.next = cur;
      prev = cur;
      if (l1 != null) l1 = l1.next;
      if (l2 != null) l2 = l2.next;
    }
    return head.next;
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    ListNode l11 = new ListNode(4);
    ListNode l12 = new ListNode(3);
    ListNode l2 = new ListNode(5);
    ListNode l21 = new ListNode(6);
    ListNode l22 = new ListNode(6);
    l1.next = l11;
    l11.next = l12;
    l2.next = l21;
    l21.next = l22;
    Solution solution = new Solution();
    ListNode head = solution.addTwoNumbers2(l1, l2);
    ListNode.printLinkedList(head);
  }
}
