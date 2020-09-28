package list;

import model.ListNode;

/** @author john.lim */
public class ReverseList {

  void printNode(ListNode node) {
    while (node != null) {
      System.out.print(node.val + " ->");
      node = node.next;
    }
    System.out.println();
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
    return prev;
  }



  // TODO: maybe can make code better
  ListNode reverseSubparts(ListNode head) {
    ListNode partend = null, curr = head;
    ListNode part = null, part_prev = null;
    while (curr != null) {

      if (curr.val % 2 == 1) {
        if(partend!=null) partend.next =null; //disconnect
        reverseList2(part);

        if (head == part) head = partend; // if the head is same as the part we update the head
        if (part_prev != null) part_prev.next = partend; // points start tp nexy
        if (part != null) part.next = curr;

        while (curr.val % 2 == 1) {
          part_prev = curr;
          part = curr.next; // cleat
          curr = curr.next;
        }

      }
      if (part == null) part = curr;

      partend = curr;
      curr = curr.next;
    }

    reverseList2(part);
    if (part_prev != null) part_prev.next = partend; // points start tp nexy

    return head;
  }

  public static void main(String[] args) {
    ReverseList rl = new ReverseList();
    // rl.reverseList();

    ListNode head = new ListNode(1);
    ListNode a = new ListNode(2);
    ListNode b = new ListNode(8);
    ListNode c = new ListNode(9);
    ListNode d = new ListNode(12);
    ListNode e = new ListNode(16);

    head.next = a;
    a.next = b;
    b.next = c;
    c.next = d;
    d.next = e;

    ;
    rl.printNode(rl.reverseSubparts(head));

    ListNode head2 = new ListNode(2);
    ListNode f = new ListNode(18);
    ListNode g = new ListNode(24);
    ListNode h = new ListNode(3);
    ListNode i = new ListNode(5);
    ListNode j = new ListNode(7);
    ListNode k = new ListNode(9);
    ListNode l = new ListNode(6);
    ListNode m = new ListNode(12);

    head2.next = f;
    f.next = g;
    g.next = h;
    h.next = i;
    i.next = j;
    j.next = k;
    k.next = l;
    l.next = m;

    rl.printNode(rl.reverseSubparts(head2));
  }
}
