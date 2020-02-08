package graph;

import model.GraphNode;

/*
Given a node rootNode, write a function getCheapestCost that calculates the minimal Sales Path cost in the tree.

using dfs
*/
public class MinimumSalesPath {
  int getCheapestCost(GraphNode rootNode) {
    // your code goes here
    if (rootNode == null) return 0;

    GraphNode[] c = rootNode.children;
    if (c == null || c.length == 0) return rootNode.val;

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < c.length; i++) {
      min = Math.min(rootNode.val + getCheapestCost(c[i]), min);
    }
    return min;
    // your code goes here
  }

  /**
   * ******************************************* Driver program to test above method *
   * *******************************************
   */
  public static void main(String[] args) {
    GraphNode r = new GraphNode(0);
    GraphNode a = new GraphNode(5);
    GraphNode b = new GraphNode(3);
    GraphNode c = new GraphNode(6);
    GraphNode d = new GraphNode(4);
    GraphNode e = new GraphNode(2);
    GraphNode f = new GraphNode(0);
    GraphNode g = new GraphNode(1);
    GraphNode h = new GraphNode(5);
    GraphNode i = new GraphNode(1);
    GraphNode j = new GraphNode(1);
    GraphNode k = new GraphNode(10);

    r.children = new GraphNode[] {a, b, c};


    a.children = new GraphNode[] {d};
    b.children = new GraphNode[] {e, f};
    c.children = new GraphNode[] {g, h};

    e.children = new GraphNode[] {i};
    f.children = new GraphNode[] {k};

    i.children = new GraphNode[] {j};

    System.out.println(new MinimumSalesPath().getCheapestCost(r));
  }
}
