package list;

import model.ListNode;

/** @author john.lim */
public class ReverseList {

  public void printNode(ListNode node) {
    while (node != null) {
      System.out.println(node.val);
      node = node.next;
    }
  }

  public static void main(String[] args) {
    ReverseList rl = new ReverseList();
    rl.reverseList();
  }

  public void reverseList() {
    ListNode a = new ListNode(2);
    ListNode b = new ListNode(1);

    ListNode c = new ListNode(1);

    ListNode d = new ListNode(2);

    a.next = b;
    b.next = c;
    c.next = d;
    reverseList2(a).print();

    // palindrome check
    System.out.println(a.equals(reverseList(a)));
  }

  public ListNode reverseList(ListNode head) {
    ListNode res = null;
    ListNode prev = null;

    while (head != null) {
      res = new ListNode(head.val);
      res.next = prev;
      prev = res;
      head = head.next;
    }

    return res;
  }

  public ListNode reverseList2(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    ListNode next = null;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    head = prev;
    return head;
  }
}
