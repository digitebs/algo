package tree;

import model.TreeNode;

/*
  find the 2nd largest element in teh binary tree

        50
	    /   \
	   30    70
	  / \    / \
	 10  40 60  80
 */
public class FindSecondLargest {
  public int findSecondLargest(TreeNode rootNode) {
    TreeNode parent = null;
    TreeNode right = rootNode;
    while(right.right!=null){
      parent = right;
      right = right.right;
    }
    TreeNode left = right.left;
    if(left == null)   return parent.val;
    while(left.right!=null) left = left.right;
    return left.val;
  }

  public static void main(String[] args) {
    TreeNode root = new  TreeNode(50);
    TreeNode a  = root.left = new TreeNode(30);
    a.left = new TreeNode(10);
    a.right = new TreeNode(40);
    TreeNode b  = root.right = new TreeNode(70);
    b.left = new TreeNode(60);
    b.right = new TreeNode(80);

    FindSecondLargest fsl= new FindSecondLargest();
    System.out.println(fsl.findSecondLargest(root));
  }
}
