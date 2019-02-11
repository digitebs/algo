package tree;

import model.TreeNode;
import org.junit.Test;

import java.util.ArrayList;

public class TreeMaxPath {

    public int print(TreeNode node, ArrayList path)
    {
        if(node==null)
        {
            return 0;
        }

        path.add(node.val);

        if(node.left==null && node.right==null)
        {

            System.out.println(path);
            return (int)path.stream().distinct().count();
        }
        else
        {
            return Math.max(print(node.left,new ArrayList(path)),print(node.right,new ArrayList(path)));
        }
    }


    @Test
    public void solution(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        System.out.println(print(root, new ArrayList()));
        // System.out.println();
        //System.out.println(solutionStack("(())))("));
        /**
         System.out.println(solutionPassowrd("a0Baa33a"));
         System.out.println(solutionPassowrd("a0Ba"));
         System.out.println(solutionPassowrd("a00a"));
         System.out.println(solutionPassowrd("00a"));
         System.out.println(solutionPassowrd("a00"));
         System.out.println(solutionPassowrd("00"));
         System.out.println(solutionPassowrd("aa"));**/
    }
}
