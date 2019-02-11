package graph;

import model.GraphNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by johnlim on 10/2/16.
 */
public class GraphDfsBfs {


    private void bfs(GraphNode root) {
        GraphNode child;
        Queue<GraphNode> q = new LinkedList();
        q.add(root);
        while (!q.isEmpty() && (child = q.remove()) != null) {
            System.out.println(child.value);
            for (int i = 0; child.children != null && i < child.children.length; i++) {
                q.offer(child.children[i]);
            }
        }


    }

    private void dfs(GraphNode root) {

        if (root == null)
            return;
        System.out.println(root.value);
        for (int i = 0; root.children != null && i < root.children.length; i++) {
            //System.out.println(root.children[i]);
            dfs(root.children[i]);
        }
    }

    public static void main(String args[]) {

        GraphNode n = new GraphNode(0);
        n.value = 0;

        GraphNode n1 = new GraphNode(1);
        GraphNode n4 = new GraphNode(4);
        GraphNode n5 = new GraphNode(5);
        GraphNode n6 = new GraphNode(6);
        n1.children = new GraphNode[]{n4, n5, n6};

        GraphNode n2 = new GraphNode(2);
        GraphNode n7 = new GraphNode(7);
        GraphNode n8 = new GraphNode(8);
        GraphNode n9 = new GraphNode(9);
        n2.children = new GraphNode[]{n7, n8, n9};

        GraphNode n3 = new GraphNode(3);
        GraphNode n10 = new GraphNode(10);
        GraphNode n11 = new GraphNode(11);
        GraphNode n12 = new GraphNode(12);
        n3.children = new GraphNode[]{n11, n12, n10};

        n.children = new GraphNode[]{n1, n2, n3};

        new GraphDfsBfs().dfs(n);

    }
}
