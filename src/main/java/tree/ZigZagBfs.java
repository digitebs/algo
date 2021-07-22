package tree;

import java.util.List;
import model.Node;
import model.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/*
               1
	          / \
	        /     \
	       2       3
	     / \       / \
	    4   5     6   7
	  / \  / \   / \  / \
     8  9 10 11 12 13 14 15
 */
public class ZigZagBfs {
  static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

    // bfs but right first

    List<List<Integer>> outer = new ArrayList();
    List<Integer> inner;

    if(root==null) return outer;
    Stack<TreeNode> r = new Stack();
    Stack<TreeNode> l = new Stack();
    r.push(root);


    while (!r.isEmpty()) {
      inner = new ArrayList();
      while (!r.isEmpty()) {
        TreeNode t = r.pop();
        if (t.left != null) l.push(t.left);
        if (t.right != null) l.push(t.right);
        inner.add(t.val);
      }
      if (!inner.isEmpty()) outer.add(inner);

      inner = new ArrayList();
      while (!l.isEmpty()) {
        TreeNode t = l.pop();
        if (t.right != null) r.push(t.right);
        if (t.left != null) r.push(t.left);
        inner.add(t.val);
      }
      if (!inner.isEmpty()) outer.add(inner);
    }
    return outer;
  }

  public static void main(String[] args) {

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

    System.out.println(zigzagLevelOrder(a));
  }
}
