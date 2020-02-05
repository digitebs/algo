package model;

import static java.lang.System.out;

public class ListNode {
  public ListNode next;
  private ListNode last = this; // intializs to itself
  public int val;

  public ListNode(int x) {
    val = x;
  }

  public void add(ListNode n) {
    last.next = n;
    last = last.next;
  }

  boolean equals(ListNode b) {
    ListNode a = this;
    while (a != null && b != null) {
      if (a.val != b.val) return false;
      a = a.next;
      b = b.next;
    }
    return true;
  }

  public void print() {
    ListNode ln = this;
    assert ln != null;
    out.print(ln.val);
    while ((ln = ln.next) != null) out.printf("->%d", ln.val);
    out.println();
  }
}
