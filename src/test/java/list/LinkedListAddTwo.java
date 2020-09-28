package list;

import model.ListNode;

public class LinkedListAddTwo {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode res = new ListNode(0); // starts;
    ListNode cur = res; // starts;

    int carry = 0;
    while (l1 != null || l2 != null) {
      int v1 = l1 == null ? 0 : l1.val;
      int v2 = l2 == null ? 0 : l2.val;
      int sum = v1 + v2 + carry; // append remainder
      carry = sum / 10;
      cur.next = new ListNode(sum % 10);
      cur = cur.next;
      l1 = l1 == null ? l1 : l1.next;
      l2 = l2 == null ? l2 : l2.next;
    }
    if (carry > 0) cur.next = new ListNode(carry);
    return res.next;
  }

  public static void main(String[] args) {
    ListNode a = new ListNode(9);
    a.next = new ListNode(1);
    ListNode b = new ListNode(2);

    LinkedListAddTwo llat = new LinkedListAddTwo();
    llat.addTwoNumbers(a,b).print();

  }
}
