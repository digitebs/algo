package tree;

import model.Node;

/** @author john.lim */
public class TreeSearch {
  public Node searchBST(Node root, int val) {
    if (root == null) return null;
    if (root.val < val) return searchBST(root.right, val);
    else if (root.val > val) return searchBST(root.left, val);
    else return root;
  }
}
