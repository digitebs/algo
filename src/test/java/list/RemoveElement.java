package list;

import model.ListNode;

public class RemoveElement {
  public ListNode removeElements(ListNode head, int val) {

    ListNode curr = head;
    ListNode prev = new ListNode(-1);
    ListNode head2 = prev;
    prev.next = curr;

    while (curr != null) {
      if (curr.val == val) {
        prev.next = curr.next;
      } else {
        prev = curr;
      }
      curr = curr.next;
    }
    return head2.next;
  }
}
