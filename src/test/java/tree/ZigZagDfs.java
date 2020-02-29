package tree;

import model.Node;
import model.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/*
               1
	          / \
	        /     \
	       2       3
	     / \       / \
	    4   5     6   7
	  / \  / \   / \  / \
     8  9 10 11 12 13 14 15
 */
public class ZigZagDfs {
  static ArrayList<ArrayList<Integer>> zigzagLevelOrder(Node a) {

    // bfs but right first

    ArrayList<ArrayList<Integer>> outer = new ArrayList();
    ArrayList<Integer> inner;

    Stack<Node> r = new Stack();
    Stack<Node> l = new Stack();
    r.push(a);

    while (!r.isEmpty()) {
      inner = new ArrayList();
      while (!r.isEmpty()) {
        Node t = r.pop();
        if (t.left != null) l.push(t.left);
        if (t.right != null) l.push(t.right);
        inner.add(t.val);
      }
      if (!inner.isEmpty()) outer.add(inner);

      inner = new ArrayList();
      while (!l.isEmpty()) {
        Node t = l.pop();
        if (t.right != null) r.push(t.right);
        if (t.left != null) r.push(t.left);
        inner.add(t.val);
      }
      if (!inner.isEmpty()) outer.add(inner);
    }
    return outer;
  }

  public static void main(String[] args) {

    Node a = new Node(1);
    a.left = new Node(2);
    a.right = new Node(3);
    a.left.left = new Node(4);
    a.left.right = new Node(5);
    a.right.left = new Node(6);
    a.right.right = new Node(7);
    a.left.left.left = new Node(8);
    a.left.left.right = new Node(9);
    a.left.right.left = new Node(10);
    a.left.right.right = new Node(11);
    a.right.left.left = new Node(12);
    a.right.left.right = new Node(13);
    a.right.right.left = new Node(14);
    a.right.right.right = new Node(15);

    System.out.println(zigzagLevelOrder(a));
  }
}
