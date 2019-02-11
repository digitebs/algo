package tree;

import model.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class ZigZagDfs {
    static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {

        // bfs but right first

        ArrayList<ArrayList<Integer>> outer = new ArrayList();
        ArrayList<Integer> inner;

        Stack<TreeNode> r = new Stack();
        Stack<TreeNode> l = new Stack();
        r.push(a);


        while (!r.isEmpty()) {
            inner = new ArrayList();
            while (!r.isEmpty()) {
                TreeNode t = r.pop();
                if (t.left != null) l.push(t.left);
                if (t.right != null) l.push(t.right);
                inner.add(t.val);
            }
            if (!inner.isEmpty()) outer.add(inner);

            inner = new ArrayList();
            while (!l.isEmpty()) {
                TreeNode t = l.pop();
                if (t.right != null) r.push(t.right);
                if (t.left != null) r.push(t.left);
                inner.add(t.val);
            }
            if (!inner.isEmpty()) outer.add(inner);
        }
        return outer;
    }
    public static void main(String[] args) {
        zigzagLevelOrder(new TreeNode(1));
    }
}
