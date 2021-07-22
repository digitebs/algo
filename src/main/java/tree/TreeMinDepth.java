package tree;

import model.TreeNode;

/*
 given root node, find the min depth of tree (using dfs)
*/
public class TreeMinDepth {
  int minDepth(TreeNode root) {

    if (root == null) {
      return 0;
    }
    return (int) minDepth(root, 1);
  }

  double minDepth(TreeNode root, double count) {

    double left, right;
    left = right = 1e4;
    if (root.left == null && root.right == null) {
      return count;
    }
    if (root.left != null) {
      left = minDepth(root.left, count + 1);
    }
    if (root.right != null) {
      right = minDepth(root.right, count + 1);
    }

    return Math.min(left, right);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(6);
    root.right.right = new TreeNode(7);
    root.left = new TreeNode(2);
    root.left.right = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.left.right.left = new TreeNode(5);

    TreeMinDepth td = new TreeMinDepth();
    System.out.println(td.minDepth(root));
  }
}
