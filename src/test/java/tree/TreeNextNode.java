package tree;

import model.Node;
import model.TreeNode;

public class TreeNextNode {
  /*
     if your given the parent, find next. o(n) solution
  */
  static Node findInOrderSuccessor(Node node) {

    if (node == null) return null;
    if (node.right != null) {
      Node left = node.right; // initially left is node right
      while (left != null && left.left != null) left = left.left;
      return left;
    }

    if (node.right == null) {
      Node curr = node;
      while (curr.parent != null && curr.parent.left.val != curr.val) curr = curr.parent;
      return curr.parent;
    }
    return null;

    // your code goes here
    // 14, go to the parent->
    // check if 14 is right or left
    // if its on teh right
    // up 12
    // 9 if 9 is on the right
    // current 9 20, 9 is right left = return (20)
    // once you got a left

    // if 14.right == empty go check the parent

    // 9 has right go right
    /*

     /*


    // node;
     if(node.right == null){
       curr = node;
       parent = node.parent
       while(parent.left.val != curr.val){
        curr= parent;
       }
     }
     if(node.left == null) return node.right;
     while(left.left!=null){
      left = node.left;
     }
     return left;

     */
    /*
    if(node == null) return;


    */

    // return node;

  }

  public static void main(String[] args) {
    //
    Node a = new Node(20);
    a.left = new Node(9);
    a.left.parent = a;
    a.right = new Node(25);
    a.right.parent = a;
    a.left.left = new Node(5);
    a.left.left.parent = a.left;
    a.left.right = new Node(12);
    a.left.right.parent = a.left;
    a.right.left = new Node(11);
    a.right.left.parent = a.right;
    a.right.right = new Node(14);
    a.right.right.parent = a.right;

    System.out.println(findInOrderSuccessor(a).val);
  }
}
