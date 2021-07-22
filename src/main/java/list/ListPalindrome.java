package list;

import model.ListNode;

/*
   check if list is palindrome use O(n)
*/
public class ListPalindrome {

  public ListNode reverseList(ListNode head) {
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

  boolean isListPalindrome(ListNode l) {
    ListNode fast = l;
    ListNode slow = l;

    if(l == null) return true;
    // find midpoint using slow and fast pointer
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next; // moeb one at a time
    }
    // 1 2

    ListNode reverse = reverseList((slow.next != null) ? slow.next : slow);

    while (reverse != null) {
      if (reverse.val != l.val) return false;
      reverse = reverse.next;
      l = l.next;
    }

    return true;
  }

  public static void main(String[] args) {
    //

    ListPalindrome lp = new ListPalindrome();
    ListNode n = new ListNode(0);
    n.next = new ListNode(1);
    n.next.next = new ListNode(0);
    System.out.println(lp.isListPalindrome(n));

    ListNode n1 = new ListNode(0);
    n1.next = new ListNode(0);
    System.out.println(lp.isListPalindrome(n1));

    ListNode n2 = new ListNode(0);
    n2.next = new ListNode(1);
    System.out.println(lp.isListPalindrome(n2));

    ListNode n3 = new ListNode(0);
    n3.next = new ListNode(1);
    n3.next.next = new ListNode(1);
    n3.next.next.next = new ListNode(0);
    System.out.println(lp.isListPalindrome(n3));

    ListNode n4 = new ListNode(0);
    n4.next = new ListNode(1);
    n4.next.next = new ListNode(1);
    n4.next.next.next = new ListNode(2);
    System.out.println(lp.isListPalindrome(n4));

    ListNode n5 = new ListNode(0);
    n5.next = new ListNode(1);
    n5.next.next = new ListNode(1);
    System.out.println(lp.isListPalindrome(n5));

    ListNode n6 = new ListNode(0);
    System.out.println(lp.isListPalindrome(n6));

    ListNode n7 = new ListNode(1);
    n7.next = new ListNode(1000000000);
    n7.next.next = new ListNode(-1000000000);
    n7.next.next.next = new ListNode(-1000000000);
    n7.next.next.next.next = new ListNode(1000000000);
    n7.next.next.next.next.next = new ListNode(1);
    System.out.println(lp.isListPalindrome(n7));

    System.out.println(lp.isListPalindrome(null));
  }
}
