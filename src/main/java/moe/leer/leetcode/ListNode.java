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
    System.out.print(listToString(head));
  }

  public static String listToString(ListNode head) {
    StringBuilder sb = new StringBuilder();
    while (head != null) {
      sb.append(head.val);
      head = head.next;
      if (head != null) sb.append("->");
    }
    sb.append("\n");
    return sb.toString();
  }
}
