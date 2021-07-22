package tree;

import model.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/** connect all the children of perfect binary tree (using bfs) */
public class ConnectPerfectTree {
  public Node connect(Node root) {
    // bfs
    if (root == null) return null;
    Queue<Node> q = new LinkedList<>();
    q.offer(root);
    root.next = null; // okay assign null
    while (!q.isEmpty()) {
      Node prev = null;
      for (Node n : new ArrayList<>(q)) {
        if (n.left != null) { // immediately break the loop as we are at the bottom of the leaf
          if (prev != null) prev.next = n.left;
          q.offer(n.left);
          n.left.next = n.right;
          q.offer(n.right);
          prev = n.right;
        }
        q.poll();
      }
    }
    return root;
  }
}
