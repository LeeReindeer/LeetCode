package moe.leer.leetcode.p083;

import moe.leer.leetcode.ListNode;

import java.util.List;
import java.util.Random;

/**
 * @author leer
 * Created at 7/13/19 8:20 AM
 * <p>
 * 83. Remove Duplicates from Sorted List
 */
public class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode savedHead = head;
    while (head != null && head.next != null) {
      if (head.val == head.next.val) {
        head.next = head.next.next;
      } else {
        head = head.next;
      }
    }
    return savedHead;
  }

  public ListNode deleteDuplicates2(ListNode head) {
    if (head == null || head.next == null) return head;
    head.next = deleteDuplicates(head.next);
    return head.val == head.next.val ? head.next : head;
  }


  public static void main(String[] args) {
    ListNode head = ListNode.buildList(new int[]{1, 1, 2, 3, 3});
    ListNode.printLinkedList(new Solution().deleteDuplicates2(head));
    ListNode.printLinkedList(new Solution().deleteDuplicates(head));
  }
}
