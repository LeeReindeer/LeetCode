package moe.leer.leetcode.p019;

import moe.leer.leetcode.ListNode;

/**
 * @author leer
 * Created at 5/12/19 3:30 PM
 */
public class Test {

  @org.junit.Test
  public void test1() {
    ListNode node1 = createTestHead();
    ListNode.printLinkedList(node1);
    Solution solution = new Solution();
    for (int i = 1; i <= 5; i++) {
      node1 = createTestHead();
      ListNode.printLinkedList(solution.removeNthFromEnd2(node1, i));
    }
  }

  ListNode createTestHead() {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = null;
    return node1;
  }

}
