package tree;

import model.Node;

import java.util.ArrayList;
import java.util.Stack;

public class ZigZagDfs {
    static ArrayList<ArrayList<Integer>> zigzagLevelOrder(Node a) {

        // bfs but right first

        ArrayList<ArrayList<Integer>> outer = new ArrayList();
        ArrayList<Integer> inner;

        Stack<Node> r = new Stack();
        Stack<Node> l = new Stack();
        r.push(a);


        while (!r.isEmpty()) {
            inner = new ArrayList();
            while (!r.isEmpty()) {
                Node t = r.pop();
                if (t.left != null) l.push(t.left);
                if (t.right != null) l.push(t.right);
                inner.add(t.val);
            }
            if (!inner.isEmpty()) outer.add(inner);

            inner = new ArrayList();
            while (!l.isEmpty()) {
                Node t = l.pop();
                if (t.right != null) r.push(t.right);
                if (t.left != null) r.push(t.left);
                inner.add(t.val);
            }
            if (!inner.isEmpty()) outer.add(inner);
        }
        return outer;
    }
    public static void main(String[] args) {
        zigzagLevelOrder(new Node(1));
    }
}
