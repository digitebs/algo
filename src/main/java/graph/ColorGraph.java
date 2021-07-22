package graph;

import java.util.HashSet;
import java.util.Set;
import model.GraphNode;

/*

  Given an undirected graph ↴ with maximum degree D, find a graph coloring D using at most
D+1 colors.

  graph coloring is where 2 adjacent nodes should not have the same color
 */
public class ColorGraph {

  public static void colorGraph(GraphNode[] graph, String[] colors) {

    // create a valid coloring for the graph
    for (GraphNode g : graph) {
      int i = 0;
      Set<String> illegal = new HashSet<>();
      // System.out.println(g.val);
      for (GraphNode n : g.children) {
        if (n == g) throw new IllegalArgumentException("cycle found");
        if (n.color != null) {
          illegal.add(n.color);
        }
      }
      for (String color : colors) {
        if (!illegal.contains(color)) {
          g.color = color;
          break;
        }
      }
    }

  }


  public static void main(String[] args) {
    String[] colors = new String[]{"red", "green", "blue", "orange", "yellow", "white"};
    GraphNode a = new GraphNode(1);
    GraphNode b = new GraphNode(2);
    GraphNode c = new GraphNode(3);
    GraphNode d = new GraphNode(4);
    a.children = new GraphNode[]{b};
    b.children = new GraphNode[]{a, c};
    c.children = new GraphNode[]{b, d};
    d.children = new GraphNode[]{c};
    GraphNode[] graph = {a, b, c, d};
    colorGraph(graph, colors);

    for (GraphNode g :
        graph) {
      System.out.println(g.color);
    }
  }
}
