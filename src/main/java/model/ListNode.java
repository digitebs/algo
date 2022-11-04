package model;

public class ListNode {

  private ListNode last = this; // intializs to itself
  public ListNode next;
  public int val;
  public ListNode(int x) {
    val = x;
  }
  public ListNode(int val, ListNode next) {this.val = val; this.next = next;}

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
    StringBuilder res = new StringBuilder(String.valueOf(ln.val));
    while ((ln = ln.next) != null) {
      res.append(String.format("->%d", ln.val));
    }
    return res.toString();
  }
}
