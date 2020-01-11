package tree;

import model.Node;

public class TreeSymmetric {
    // recursively comparing the left to the right and the right to left
    boolean isSymmetric(Node l, Node r){
        if(r==null && l == null) return true;
        if(r!=null && l!= null && r.val == l.val){
            return isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);

        }
        return false;
    }
    public boolean isSymmetric(Node root) {
        return isSymmetric(root.left, root.right);
    }
}
