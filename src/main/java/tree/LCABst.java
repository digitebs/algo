package tree;

import model.TreeNode;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 */
public class LCABst {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      while(root!=null){
        if(root.val > p.val && root.val > q.val){
          root = root.left;
        }else if(root.val < p.val && root.val < q.val){
          root = root.right;
        }else{
          break;
        }
      }

      return root;
  }
  public static void main(String[] args) {
    var lca = new LCABst();
    var root = new TreeNode(6);
     root.left = new TreeNode(2);
     root.right = new TreeNode(8);
     assert lca.lowestCommonAncestor(root, root.left, root.right).val == 6;
  }
}
