package list;

import model.Node;

import java.util.HashMap;

/**
 * clone ll with next and rand pointer
 *
 * @author john.lim
 */
public class LinkedListClone {

  Node clone(Node e) {
    HashMap<Node, Node> hm = new HashMap<>();
    Node curr = e;
    if (curr == null) return null;

    while (curr != null) {
      hm.put(curr, new Node(curr.val));
      curr = curr.next;
    }

    curr = e;
    Node res, head;
    head = res = hm.get(curr);
    while (curr != null) {
      res.next = hm.get(curr.next);
      res.right = hm.get(curr.right);
      res = res.next;
      curr = curr.next;
    }
    return head;
  }

  public static void main(String[] args) {
    LinkedListClone llc = new LinkedListClone();
    Node a = new Node(1);
    Node b = new Node(2);
    Node c = new Node(3);
    Node d = new Node(4);
    Node e = new Node(5);
    a.next = b;
    a.right = d;
    a.next.next = c;
    a.next.right = b;
    a.next.next.next = d;
    a.next.next.right = b;
    a.next.next.next.next = e;
    a.next.next.next.right = c;

    Node ans = llc.clone(a);

    System.out.println(ans.val);
    System.out.println(ans.next.val);
    System.out.println(ans.next.next.val);
    System.out.println(ans.next.next.next.val);
    System.out.println(ans.next.next.next.next.val);
    System.out.println(ans.next.next.next.right.val);
    System.out.println(ans.next.next.right.val);
    System.out.println(ans.next.right.val);
    System.out.println(ans.right.val);
  }
}
