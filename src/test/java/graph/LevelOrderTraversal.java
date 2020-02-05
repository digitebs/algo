package graph;

import model.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author john.lim
 */
public class LevelOrderTraversal {

    public ArrayList<ArrayList<Integer>> levelOrder(Node a) {
        // HashSet<Node> end = new HashSet<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> data = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(a);
        //end.add(a);
        while (!q.isEmpty()) {
            int ln = q.size();
            while(ln --> 0) {
                Node tn = q.poll();
                if(tn == null) continue;
                data.add(tn.val);
                if (tn.left != null) q.add(tn.left);
                if (tn.right != null) q.add(tn.right);
            }
            res.add(data);
            data= new ArrayList<>();
        }

        return res;
    }

    public static void main(String[] args) {
        Node a = new Node(3);
        a.left = new Node(9);
        a.right = new Node(20);
        a.left.left = new Node(6);
        a.left.right = new Node(8);
        a.left.left.right = new Node(9);
        //a.right.left = new Node(15);
        //a.right.right = new Node(7);
        System.out.println(new LevelOrderTraversal().levelOrder(a));
    }

}




