package moe.leer.leetcode.p142;

import moe.leer.leetcode.ListNode;

/**
 * @author leer
 * Created at 9/12/19 10:31 PM
 */
public class Solution {

  public ListNode detectCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      // assume a is the begin of the cycle.
      // when fast meet slow, say the slow pointer travels a + b, the fast travels 2a + 2b
      // cycle length = n, a+b+n = 2a+2b -> n = a+b
      // then let slower pointer travel a, the node is the begin of the cycle
      if (fast == slow) {
        ListNode slow2 = head;
        while (slow2 != slow) {
          slow = slow.next;
          slow2 = slow2.next;
        }
        return slow;
      }

    }
    return null;
  }

}
