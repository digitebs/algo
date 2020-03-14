package tree;

import model.Node;

/*
  check if a given binary tree is symmetric or not

  Input:
    1
   / \
  2   2
 / \ / \
3  4 4  3

Output: true
 */
public class TreeSymmetric {
  // recursively comparing the left to the right and the right to left
  boolean isSymmetric(Node l, Node r) {
    if (r == null && l == null) return true;
    if (r != null && l != null && r.val == l.val) {
      return isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
    }
    return false;
  }

  public boolean isSymmetric(Node root) {
    return isSymmetric(root.left, root.right);
  }
}
