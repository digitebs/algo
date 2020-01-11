package tree;

import model.Node;

/**
 * tree traversal using dfs;
 */
public class TreeDfsSearch {

    static boolean dfs(Node n, int v){
        if(n == null) return false;
        if(n.val == v) return true;
        else return dfs(n.left,v) || dfs(n.right,v);
    }
    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);
        n.left.left = new Node(4);
        n.left.right  = new Node(5);
        n.right.left = new Node(6);
        n.right.right  = new Node(7);

        System.out.println(dfs(n,4));
    }
}
