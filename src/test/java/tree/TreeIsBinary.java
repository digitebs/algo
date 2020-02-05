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
    System.out.println(isBst(tn, Integer.MIN_VALUE, Integer.MAX_VALUE));
  }
}
