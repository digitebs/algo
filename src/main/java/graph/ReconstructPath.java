package graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
  return teh shortest path, this using bfs. return the path
 */
public class ReconstructPath {

  public static String[] reconstructPath(Map<String, String> hm, String start, String end) {
    String curr = end;
    List<String> path = new ArrayList<>();
    while (curr != null) {
      path.add(curr);
      curr = hm.get(curr);
    }
    Collections.reverse(path);
    return path.toArray(new String[0]);

  }

  public static String[] getPath(Map<String, String[]> graph, String start,
      String end) {

    // find the shortest route in the network between the two users
    Queue<String> q = new LinkedList<>();
    q.offer(start);

    Map<String, String> visited = new HashMap<>();
    visited.put(start, null); // visited now is a map with key that points to its parent


    if (!graph.containsKey(start))
      throw new IllegalArgumentException("err");
    if (!graph.containsKey(end))
      throw new IllegalArgumentException("err");

    while (!q.isEmpty()) {
      String curr = q.poll();
      if (curr.equals(end)) return reconstructPath(visited, start, end);
      for (String child : graph.get(curr)) {
        if (!visited.containsKey(child)) {
          q.offer(child);
          visited.put(child, curr);
        }
      }
    }
    return null;
  }

  public static void main(String[] args) {
    Map<String,String[]> network = new HashMap<String, String[]>() { {
      put("a", new String[] {"b", "c", "d"});
      put("b", new String[] {"a", "d"});
      put("c", new String[] {"a", "e"});
      put("d", new String[] {"a", "b"});
      put("e", new String[] {"c"});
      put("f", new String[] {"g"});
      put("g", new String[] {"f"});
    }};

    ReconstructPath rp = new ReconstructPath();
    System.out.println(Arrays.toString(rp.getPath(network,"a","e")));
    System.out.println(Arrays.toString(rp.getPath(network,"a","a")));
    System.out.println(Arrays.toString(rp.getPath(network,"a","f")));
  }

}
