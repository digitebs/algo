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

  static int height(TreeNode node)
  {
    /* base case tree is empty */
    if (node == null)
      return 0;

        /* If tree is not empty then height = 1 + max of left
         height and right heights */
    return 1 + Math.max(height(node.left), height(node.right));
  }

  static int checkHeight(TreeNode node) {
    if (node == null) return 0;
    int left,right ;
    if ((left=checkHeight(node.left)) < 0) return left;
    if ((right=checkHeight(node.right)) < 0) return right;

    if (Math.abs(left - right) > 1) return -1;
    return Math.max(left, right) + 1;
  }


  static boolean isBalanced(TreeNode node) {
    /* If tree is empty then return true */
    if (node == null)
      return true;

    /* Get the height of left and right sub trees */
    int l = height(node.left);
    int h = height(node.right);

    if (Math.abs(l - h) <= 1
        && isBalanced(node.left)
        && isBalanced(node.right))
      return true;

    /* If we reach here then tree is not height-balanced */
    return false;

  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(1);
    root.right = new TreeNode(0);
    root.right.right= new TreeNode(7);
    root.right.right.right = new TreeNode(8);

    System.out.println(isBalanced(root));
  }
}
