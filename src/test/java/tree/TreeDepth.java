package tree;

import model.TreeNode;

/*
  given root node, find the depth of tree (using dfs)
 */
public class TreeDepth {
  int dfs(TreeNode root){

    if(root == null) return 0;

    int l = dfs(root.left);
    int r = dfs(root.right);


    return 1 + Math.max(l,r);

  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.right = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.left.right.left = new TreeNode(5);

    TreeDepth td = new TreeDepth();
    System.out.println(td.dfs(root));
  }
}
