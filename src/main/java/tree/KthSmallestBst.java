package tree;

import java.util.Stack;
import model.TreeNode;

public class KthSmallestBst {

  public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> s = new Stack();
    while(root!=null || !s.isEmpty()){
      while(root!=null){
        s.push(root);
        root = root.left;
      }
      root = s.pop();
      if(--k == 0) break;
      root = root.right;

    }

    return root.val;

  }

  public static void main(String[] args) {
    KthSmallestBst ksb = new KthSmallestBst();
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.left.left.left = new TreeNode(4);
    System.out.println(ksb.kthSmallest(root,3));
  }
}
