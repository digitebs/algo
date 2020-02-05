package tree;

import model.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class Node { int val; Node left; Node right; Node(int
 * x) { val = x; } }
 */
public class TreeCodec {
  // Encodes a tree to a single string.
  public String serialize(Node root) {
    StringBuilder sb = new StringBuilder();
    if (root == null) return sb.toString();
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      int level = q.size();
      for (int i = 0; i < level; i++) {
        Node n = q.poll();
        sb.append(" ");
        if (n == null) sb.append(Character.MIN_VALUE);
        else {
          sb.append(n.val);
          q.offer(n.left);
          q.offer(n.right);
        }
      }
    }
    return sb.deleteCharAt(0).toString();
  }

  public Node deserialize(String data) {
    if (data.length() == 0) return null;
    String[] arr = data.split(" ");
    Queue<Node> q = new LinkedList<>();
    Node tn = new Node(Integer.parseInt(arr[0]));
    Node root = tn;
    q.offer(tn);
    for (int i = 1; !q.isEmpty(); i += 2) {
      if (i < arr.length) {
        tn = q.poll();
        if (arr[i].charAt(0) != Character.MIN_VALUE)
          q.offer(tn.left = new Node(Integer.parseInt(arr[i].trim())));
        if (arr[i + 1].charAt(0) != Character.MIN_VALUE)
          q.offer(tn.right = new Node(Integer.parseInt(arr[i + 1].trim())));
      }
    }
    return root;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
