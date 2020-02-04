package tree;

import model.Node;

public class TreeNextNode {
    /*
        if your given the parent, find next. o(n) solution
     */
    Node findInOrderSuccessor(Node node) {

        if(node == null) return null;
        if(node.right != null){
            Node left = node.right; //initially left is node right

            while(left!=null && left.left!=null) left = left.left;
            return left;
        }

        if(node.right == null){
            Node curr = node;
            while( curr!= null && curr.parent!=null && curr.parent.left.val != curr.val)
                curr=curr.parent;
            if(curr == null) return null;
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



        //return node;


    }

    public static void main(String[] args) {

    }
}
