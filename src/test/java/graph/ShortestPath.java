package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;
import model.Tuple;

/*
  dijkstra shortest path works only on positive weighted graph cycle

  use bellman ford if there is negative weights
 */
public class ShortestPath {

  // distance???
  public int[] dijkstra(List<Tuple>[] adj, int src) {
    int V = adj.length;
    PriorityQueue<Tuple> pq = new PriorityQueue<>(V, (a, b) -> a._2 - b._2);
    int[] dist = new int[V]; // number of vertices
    Arrays.fill(dist, Integer.MAX_VALUE);
    boolean[] visited = new boolean[V];

    pq.add(new Tuple(src, 0));
    dist[src] = 0;
    while (!pq.isEmpty()) {
      int u = pq.poll()._1;
      visited[u] = true;
      for (int i = 0; i < adj[u].size(); i++) {
        Tuple v = adj[u].get(i);
        int d = dist[u] + v._2;
        if (!visited[v._1]) {
          dist[v._1] = Math.min(dist[v._1], d);
          pq.add(new Tuple(v._1, dist[v._1]));
        }
      }
    }
    return dist;
  }

  public static void main(String[] args) {
    ShortestPath sp = new ShortestPath();

    List<Tuple>[] adj = Stream.iterate(0, x -> x + 1)
        .map(x -> new ArrayList<>()).limit(5)
        .toArray(List[]::new);
   /* for(int i = 0 ; i < adj.length; i++){
      adj[i] = new ArrayList<>(); // list of tuples
    }*/

    adj[0].add(new Tuple(1, 9));
    adj[0].add(new Tuple(2, 6));
    adj[0].add(new Tuple(3, 5));
    adj[0].add(new Tuple(4, 3));

    adj[2].add(new Tuple(1, 2));
    adj[2].add(new Tuple(3, 4));

    int source = 0;
    int[] dist = sp.dijkstra(adj, source);

    System.out.println("The shorted path from node :");
    for (int i = 0; i < dist.length; i++) {
      System.out.println(source + " to " + i + " is "
          + dist[i]);
    }
  }
}
