package tree;

import model.TreeNode;

/**

 Given a non-empty binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes from some starting node
 to any node in the tree along the parent-child connections.
 The path must contain at least one node and does not need to go through the root.
  @author john.lim

 * */
public class MaxPathSum {
    int max;
  public int maxPathSum2(TreeNode root) {

    if (root == null) return 0;

    int l = Math.max(maxPathSum2(root.left), 0);
    int r = Math.max(maxPathSum2(root.right), 0);

    int v = l + root.val + r;
    max = Math.max(max, v);
    return root.val + Math.max(l, r);
  }

  public int maxPathSum(TreeNode root) {
    max = root.val;
    maxPathSum2(root);
    return max;
  }

  public static void main(String[] args) {

  }
}
