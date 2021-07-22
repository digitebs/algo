package tree;

import model.Node;
import model.TreeNode;


/*
    Given two binary trees, write a function to check if they are the same or not.

    Input: 1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

    Output: true

    Input:
               1
	          / \
	        /     \
	       2       2
	     / \       / \
	    3   4     6   7
	  / \  / \   / \  / \
     8  9 10 11 12 13 14 15

               1
	          / \
	        /     \
	       2       2
	     / \       / \
	    3   4     6   7
	  / \  / \   /   / \
     8  9 10 11 12   14 15

     Output: false;
 */
public class TreeIsSame {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if((q == null) ^ (p==null)) return false;
        if(p.val == q.val) return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
        return false;

    }

  public static void main(String[] args) {
    //
      TreeNode a = new TreeNode(1);
      a.left = new TreeNode(2);
      a.right = new TreeNode(3);
      a.left.left = new TreeNode(4);
      a.left.right = new TreeNode(5);
      a.right.left = new TreeNode(6);
      a.right.right = new TreeNode(7);
      a.left.left.left = new TreeNode(8);
      a.left.left.right = new TreeNode(9);
      a.left.right.left = new TreeNode(10);
      a.left.right.right = new TreeNode(11);
      a.right.left.left = new TreeNode(12);
      a.right.left.right = new TreeNode(13);
      a.right.right.left = new TreeNode(14);
      a.right.right.right = new TreeNode(15);

      TreeNode b = new TreeNode(1);
      a.left = new TreeNode(2);
      a.right = new TreeNode(3);
      a.left.left = new TreeNode(4);
      a.left.right = new TreeNode(5);
      a.right.left = new TreeNode(6);
      a.right.right = new TreeNode(7);
      a.left.left.left = new TreeNode(8);
      a.left.left.right = new TreeNode(9);
      a.left.right.left = new TreeNode(10);
      a.left.right.right = new TreeNode(11);
      a.right.left.left = new TreeNode(12);
      // a.right.left.right = new TreeNode(13);
      a.right.right.left = new TreeNode(14);
      a.right.right.right = new TreeNode(15);

      TreeIsSame tis = new TreeIsSame();
     System.out.println(tis.isSameTree(a,b));
  }
}
