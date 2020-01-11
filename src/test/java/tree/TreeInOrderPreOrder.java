package tree;

import model.Node;

import java.util.HashMap;

public class TreeInOrderPreOrder {
    HashMap<Integer,Integer> phm;
    HashMap<Integer,Integer> ihm;
    public void partition(int[] inorder, int lo, int hi, Node root){
        int min = -1;
        int l=-1;
        if(lo <= hi) {
            for(int i = lo; i <= hi; i++) if(phm.get(inorder[i]) > min) min = phm.get(inorder[l=i]);
            Node tn = new Node(inorder[l]);
            if(ihm.get(root.val) > l) root.left = tn;
            else  root.right = tn;

            partition(inorder,lo,l-1,tn);
            partition(inorder,l+1,hi,tn);
        }
    }


    public Node buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0) return null;
        phm = new HashMap<>();
        ihm = new HashMap<>();
        for(int i = 0; i < postorder.length; i++) phm.put(postorder[i],i); // create a lookup;
        for(int i = 0; i < inorder.length; i++) ihm.put(inorder[i],i); // create a lookup;

        Node root = new Node(postorder[postorder.length-1]);
        int pivot = ihm.get(root.val);
        partition(inorder,0,pivot-1,root);
        partition(inorder,pivot+1,inorder.length-1,root);
        return root;

    }
}
