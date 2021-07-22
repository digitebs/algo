package model;

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
    System.out.println(this);
  }

  @Override
  public String toString() {
    ListNode ln = this;
    String res =String.valueOf(ln.val);
    assert ln != null;
    while ((ln = ln.next) != null) {
      res+= String.format("->%d", ln.val);
     // System.out.println(res);
    }
    return res;
  }
}
