package tree;

import model.Node;

/** a balance binary tree is a where all nodes in a tree has a maxium difference of 1 in height */
public class TreeIsBalance {

  // this looks like a post order traversal, where it digs to the bottom of the left 1st
  static int checkHeight(Node node) {
    if (node == null) return -1;

    int left = checkHeight(node.left);
    if (left == Integer.MIN_VALUE) return Integer.MIN_VALUE;

    int right = checkHeight(node.right);
    if (right == Integer.MIN_VALUE) return Integer.MIN_VALUE;

    if (Math.abs(left - right) > 1) return Integer.MIN_VALUE;
    else return Math.max(left, right) + 1;
  }

  static boolean isBalance(Node root) {
    return checkHeight(root) != Integer.MIN_VALUE;
  }

  public static void main(String[] args) {}
}
