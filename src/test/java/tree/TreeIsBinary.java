package tree;

import model.TreeNode;

public class TreeIsBinary {
    /**
     * checks if tree is bst, need to tighten the left and right
     */


    static boolean isBst(TreeNode tn, int min, int max ){

        if(tn == null) return true; // we hit bottm just return true

        if(tn.val < min || tn.val > max)
            return false;

        return isBst(tn.left,min,tn.val-1) && isBst(tn.right,tn.val+1, max); // dig it, pre order traversal go left then right
    }

    public static void main(String[] args) {
        TreeNode tn = new TreeNode(3);
        TreeNode tn1 = new TreeNode(2);
        TreeNode tn2 = new TreeNode(5);
        TreeNode tn3 = new TreeNode(1);
        TreeNode tn4 = new TreeNode(4);

        tn.left= tn1;
        tn.right= tn2;
        tn1.left=tn3;
        tn1.right=tn4;
        System.out.println(isBst(tn,Integer.MIN_VALUE,Integer.MAX_VALUE));

    }
}
