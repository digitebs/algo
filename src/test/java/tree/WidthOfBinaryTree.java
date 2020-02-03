package tree;

import model.TreeNode;

import java.math.BigInteger;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
    uses big integer as tree level can go really huge
 */
public class WidthOfBinaryTree {
    static int widthOfBinaryTree(TreeNode root) {
        BigInteger width= BigInteger.ZERO;
        if(root == null) return width.intValue();
        Deque<TreeNode> q = new LinkedList<>(); // we allow null
        Deque<BigInteger> p = new LinkedList<>(); // we allow null
        q.add(root);
        p.add(BigInteger.ONE);
        while(!q.isEmpty()){
            int n = q.size();
            width  = width.max(p.peekLast().subtract(p.peekFirst()).add(BigInteger.ONE));
            for(int i =0; i < n; i++){
                TreeNode tn = q.poll();
                BigInteger pos = p.poll();
                pos = pos.multiply(BigInteger.valueOf(2));
                if(tn.left!=null){
                    q.offer(tn.left);
                    p.offer(pos.subtract(BigInteger.ONE));
                }
                if(tn.right!=null){
                    q.offer(tn.right);
                    p.offer(pos);
                }
            }
        }
        return width.intValue();
    }

    /*
            1
         /   \
        3     2
       / \     \
      5   3     9
     */
    public static void main(String[] args) {
        TreeNode tn = new TreeNode(1);
        tn.left = new TreeNode(2);
        tn.right = new TreeNode(3);
        tn.left.left = new TreeNode(5);
        tn.left.right = new TreeNode(3);
        tn.right.right = new TreeNode(9);
        System.out.println(widthOfBinaryTree(tn));
    }
}
