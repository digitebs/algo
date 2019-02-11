package tree;

import model.TreeNode;

/**
 * tree traversal using dfs;
 */
public class TreeDfsSearch {

    static boolean dfs(TreeNode n, int v){
        if(n == null) return false;
        if(n.val == v) return true;
        else return dfs(n.left,v) || dfs(n.right,v);
    }
    public static void main(String[] args) {
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(3);
        n.left.left = new TreeNode(4);
        n.left.right  = new TreeNode(5);
        n.right.left = new TreeNode(6);
        n.right.right  = new TreeNode(7);

        System.out.println(dfs(n,4));
    }
}
