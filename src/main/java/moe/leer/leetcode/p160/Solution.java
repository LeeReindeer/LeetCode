package moe.leer.leetcode.p160;

import moe.leer.leetcode.ListNode;

/**
 * @author leer
 * Created at 7/11/19 7:02 PM
 * <p>
 * 160. Intersection of Two Linked Lists
 * <p>
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 */
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;
    ListNode originA = headA, originB = headB;
    while (headA != headB) {
      headA = headA == null ? originB : headA.next;
      headB = headB == null ? originA : headB.next;
    }
    return headA;
  }

  public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
    int lenA = len(headA), lenB = len(headB);
    // 1. move A and B to same start point
    while (lenA > lenB) {
      headA = headA.next;
      lenA--;
    }
    while (lenA < lenB) {
      headB = headB.next;
      lenB--;
    }
    // 2. check if intersect
    while (headA != headB) {
      headA = headA.next;
      headB = headB.next;
    }
    return headA;
  }

  private int len(ListNode head) {
    int len = 0;
    while (head != null) {
      head = head.next;
      len++;
    }
    return len;
  }

  public static void main(String[] args) {
    ListNode list1 = new ListNode(4);
    ListNode list11 = new ListNode(1);
    ListNode list12 = new ListNode(2);
    list1.next = list11;
    list11.next = list12;
    Solution solution = new Solution();
    System.out.println(solution.len(list1));
    System.out.println(solution.getIntersectionNode(list1, list11).val);
    System.out.println(solution.getIntersectionNode2(list1, list11).val);
  }
}
