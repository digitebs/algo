package list;

import model.ListNode;

/*
  Group the odd and even list

  The first node is considered odd, and the second node is even, and so on.
 */
public class OddEvenList {
  public ListNode oddEvenList(ListNode head) {
    ListNode odd_start = null, odd = null, curr = head;
    ListNode even_start = null, even = null;

    int i = 1;
    while (curr != null) {
      if (i % 2 == 0) {
        if (even == null) {
          even = curr;
          even_start = even;
        } else {
          even.next = curr;
          even = even.next;
        }
      } else {
        if (odd == null) {
          odd = curr;
          odd_start = odd;
        } else {
          odd.next = curr;
          odd = odd.next;
        }
      }
      i++;

      curr = curr.next;
    }

    if(odd == null) return null;
    odd.next = even_start;
    if(even != null) even.next = null;
    return odd_start;
  }

  public static void main(String[] args) {
    ListNode ln = new ListNode(1);
    ln.next = new ListNode(2);
    ln.next.next = new ListNode(3);
    ln.next.next.next = new ListNode(4);
    ln.next.next.next.next = new ListNode(5);

    OddEvenList oel = new OddEvenList();
    System.out.println(
        oel.oddEvenList(ln)
    );
  }
}
