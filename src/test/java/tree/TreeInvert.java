package tree;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */
public class TreeInvert {
    static TreeNode invertTree(TreeNode root) {
        if(root ==null) return null;
        TreeNode tmp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(tmp);
        return root;
    }

    /*
        bfs print
     */
    static List<Integer> toList(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            TreeNode node = q.poll();
            res.add(node.val);
            if(node.left!=null) q.offer(node.left);
            if(node.right!=null) q.offer(node.right);
        }
        return res;
    }
  public static void main(String[] args) {
    //
      TreeNode root = new TreeNode(4);
      root.left = new TreeNode(2);
      root.left.left = new TreeNode(1);
      root.left.right = new TreeNode(3);
      root.right = new TreeNode(7);
      root.right.left = new TreeNode(6);
      root.right.right = new TreeNode(9);

      System.out.println(toList(root));
      invertTree(root);
      System.out.println(toList(root));

  }
}
