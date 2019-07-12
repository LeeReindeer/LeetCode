package moe.leer.leetcode.p024;

import moe.leer.leetcode.ListNode;

/**
 * @author leer
 * Created at 7/11/19 7:49 PM
 * <p>
 * 24. Swap Nodes in Pairs
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class Solution {
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode first = head, second = head.next;
    first.next = swapPairs(second.next); // next pair's first
    second.next = first;
    return second;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    head.next = node2;
    node2.next = node3;
    node3.next = node4;
    ListNode.printLinkedList(new Solution().swapPairs(head));
  }
}
