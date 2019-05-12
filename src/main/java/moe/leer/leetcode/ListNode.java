package moe.leer.leetcode;

/**
 * @author leer
 * Created at 5/12/19 2:48 PM
 */
public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int x) {
    val = x;
  }

  public static void printLinkedList(ListNode head) {
    while (head != null) {
      System.out.print(head.val);
      head = head.next;
      if (head != null) System.out.print("->");
    }
    System.out.println();
  }
}
