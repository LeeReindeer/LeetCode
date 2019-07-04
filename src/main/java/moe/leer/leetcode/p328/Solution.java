package moe.leer.leetcode.p328;

import moe.leer.leetcode.ListNode;

/**
 * @author leer
 * Created at 7/4/19 1:15 PM
 * <p>
 * 328. Odd Even Linked List
 * <p>
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 */
public class Solution {

  public ListNode oddEvenList(ListNode head) {
    if (head == null) return null;
    ListNode oddHead = head, evenHead = head.next;
    ListNode pOdd = oddHead, pEven = evenHead;
    while (pOdd != null && pEven != null) {
      // when next odd node occurred NULL, we save the last odd node
      if (pEven.next == null) break;
      pOdd.next = pEven.next;
      pOdd = pOdd.next;
      pEven.next = pOdd.next;
      pEven = pEven.next;
    }
    pOdd.next = evenHead;
    return oddHead;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
//    ListNode node5 = new ListNode(5);
//    head.next = node2;
//    node2.next = node3;
//    node3.next = node4;
//    node4.next = node5;
    Solution solution = new Solution();
    ListNode.printLinkedList(solution.oddEvenList(head));
  }
}
