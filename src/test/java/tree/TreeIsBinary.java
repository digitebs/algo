package tree;

import model.Node;

public class TreeIsBinary {
  /** checks if tree is bst, need to tighten the left and right */
  static boolean isBst(Node tn, int min, int max) {

    if (tn == null) return true; // we hit bottm just return true

    if (tn.val < min || tn.val > max) return false;

    return isBst(tn.left, min, tn.val - 1)
        && isBst(tn.right, tn.val + 1, max); // dig it, pre order traversal go left then right
  }

  static boolean isBST(Node root, Node l, Node r)
  {
    // Base condition
    if (root == null)
      return true;

    // if left node exist then check it has
    // correct data or not i.e. left node's data
    // should be less than root's data
    if (l != null && root.val <= l.val)
      return false;

    // if right node exist then check it has
    // correct data or not i.e. right node's data
    // should be greater than root's data
    if (r != null && root.val >= r.val)
      return false;

    // check recursively for every node.
    return isBST(root.left, l, root) &&
            isBST(root.right, root, r);
  }

  public static void main(String[] args) {
    Node tn = new Node(3);
    Node tn1 = new Node(2);
    Node tn2 = new Node(5);
    Node tn3 = new Node(1);
    Node tn4 = new Node(4);

    tn.left = tn1;
    tn.right = tn2;
    tn1.left = tn3;
    tn1.right = tn4;
    // System.out.println(isBst(tn, Integer.MIN_VALUE, Integer.MAX_VALUE));
    System.out.println(isBST(tn,null,null));
  }
}
