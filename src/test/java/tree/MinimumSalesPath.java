package tree;

import model.GraphNode;

/*
 Given a node rootNode, write a function getCheapestCost that calculates the minimal Sales Path cost in the tree.
 */
public class MinimumSalesPath {
    static int getCheapestCost(GraphNode rootNode, int sum) {
        if (rootNode == null) return sum;
        GraphNode[] c = rootNode.children;
        if (c == null || c.length == 0) {
            // lowest = Math.min(sum, lowest);
            return sum;
        }
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < c.length; i++) {
            min = Math.min(getCheapestCost(c[i], sum + c[i].val),min);
        }
        return min;
        // your code goes here
    }

    int getCheapestCost(GraphNode rootNode) {
        // your code goes here
        return getCheapestCost(rootNode, rootNode.val);
    }

    /*********************************************
     * Driver program to test above method     *
     *********************************************/

    public static void main(String[] args) {
        GraphNode n = new GraphNode(7);
        GraphNode a, b, c, d, e, f, g, h, i, j, k;
        n.children = new GraphNode[]{
                a = new GraphNode(5),
                b = new GraphNode(3),
                c = new GraphNode(6)
        };
        a.children = new GraphNode[]{
                d = new GraphNode(4)
        };

        b.children = new GraphNode[]{
                e = new GraphNode(2),
                f = new GraphNode(0),
        };

        c.children = new GraphNode[]{
                g = new GraphNode(1),
                h = new GraphNode(5),
        };

        e.children = new GraphNode[]{
                i = new GraphNode(1)
        };
        i.children = new GraphNode[]{
                j = new GraphNode(1)
        };

        f.children = new GraphNode[]{
                k = new GraphNode(10)
        };
        
        System.out.println(new MinimumSalesPath().getCheapestCost(n));
    }

}
