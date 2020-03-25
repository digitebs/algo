package tree;

import model.TreeNode;

/*
a balance binary tree is a where all nodes in a tree has a maxium difference of 1 in height
     6
   /   \
  1     0
         \
          7
           \
            8
*/
public class TreeIsBalance {

  // this looks like a post order traversal, where it digs to the bottom of the left 1st
  static int checkHeight(TreeNode node) {
    if (node == null) return 0;
    int left,right ;
    if ((left=checkHeight(node.left)) < 0) return left;
    if ((right=checkHeight(node.right)) < 0) return right;

    if (Math.abs(left - right) > 1) return -1;
    return Math.max(left, right) + 1;
  }

  static boolean isBalance(TreeNode root) {
    return checkHeight(root)  >= 0 || root.left== null ^ root.right==null;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(1);
    root.right = new TreeNode(0);
    root.right.right= new TreeNode(7);
    root.right.right.right = new TreeNode(8);

    System.out.println(isBalance(root));
  }
}
