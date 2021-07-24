package list;

import model.ListNode;

/** Created by johnlim on 3/2/17. */
public class DeleteCurrentNode {


  public void deleteNode() {
    ListNode a = new ListNode(0);
    ListNode b = new ListNode(1);
    ListNode c = new ListNode(3);
    ListNode d = new ListNode(4);
    a.next = b;
    // b.next=c;
    // sc.next=d;

    deleteNode(a);
    a.print();
  }

  /*
    remove target k from the list
   */
  ListNode removeKFromList(ListNode l, int k) {
    ListNode curr = new ListNode(-2000); // create a dummy node in front
    curr.next = l;
    l = curr;
    while (curr.next != null) {
      if (curr.next.val == k) {
        curr.next = curr.next.next; // skip it
      } else curr = curr.next;
    }
    return l.next;
  }

  public static void main(String[] args) {
    //
    DeleteCurrentNode dcn = new DeleteCurrentNode();
    ListNode n = new ListNode(3);
    n.add(new ListNode(1));
    n.add(new ListNode(2));
    n.add(new ListNode(3));
    n.add(new ListNode(4));
    n.add(new ListNode(3));

    ListNode s = dcn.removeKFromList(n, 3);
    System.out.println(s);
  }

  public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }
}
