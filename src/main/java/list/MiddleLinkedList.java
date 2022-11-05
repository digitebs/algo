package list;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import model.ListNode;

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 */
public class MiddleLinkedList {
  public ListNode middleNode(ListNode head) {
    var slow = head;
    var fast = head;
    while(fast!=null && fast.next!=null){
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
  public static void main(String[] args) {
    var mll = new MiddleLinkedList();
    var list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    System.out.println(mll.middleNode(list));
  }
}
