package list;

import model.ListNode;

public class LinkedListIntersection {
  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode curA = headA;
    ListNode curB = headB;
    while (curA != null && curB != null) {
      curA = curA.next;
      curB = curB.next;
    }

    if (curA == null) curA = headB;
    if (curB == null) curB = headA;

    System.out.println(curA.val + " " + curB.val);
    while (curA != null && curB != null) {
      curA = curA.next;
      curB = curB.next;
    }

    if (curA == null) curA = headB;
    if (curB == null) curB = headA;

    System.out.println(curA.val + " " + curB.val);
    while (curA != null && curB != null) {
      if (curA == curB) return curA;
      curA = curA.next;
      curB = curB.next;
    }
    return null;
  }

  public static void main(String[] args) {
    ListNode s1 = new ListNode(8);
    ListNode s2 = new ListNode(4);
    ListNode s3 = new ListNode(5);

    ListNode a = new ListNode(4);
    a.add(new ListNode(1));
    a.add(s1);
    a.add(s2);
    a.add(s3);
    a.print();

    ListNode b = new ListNode(5);
    b.add(new ListNode(0));
    b.add(new ListNode(1));
    b.add(s1);
    b.add(s2);
    b.add(s3);
    b.print();

    ListNode r = getIntersectionNode(a, b);
    System.out.println(r == null ? null : r.val);
  }
}
