package tree;

import model.TreeNode;

/*
        trim from tree
 */
public class TrimTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val > R) return trimBST(root.left, L, R); // continue
        if (root.val < L) return trimBST(root.right, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    /*
    how to delete node: TODO:
    If no children - Just delete.
    If a single child - Copy that child to the node.
    If two children - Determine the next highest element (inorder successor) in the right subtree.
 Replace the node to be removed with the inorder successor. Delete the inorder successor duplicate.
     */

  public static void main(String[] args) {
    //
      TreeNode a  = new TreeNode(1);
      a.left = new TreeNode(2);
      a.right = new TreeNode(3);
      a.left.left = new TreeNode(4);
      a.left.right = new TreeNode(5);
      a.right.left = new TreeNode(6);
      a.right.right = new TreeNode(7);
      System.out.println(a.toList());
  }
}
