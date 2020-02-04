package graph;

import java.util.*;

/*
    topological sort uses stack
 */
public class TopologicalSort {
    private int V;   // No. of vertices
    private HashMap<Integer,LinkedList<Integer>> adj; // Adjacency List

    TopologicalSort(int v)
    {
        V = v;
        adj = new LinkedHashMap<>();
    }

    // Function to add an edge into the graph
    void addEdge(int v,int w) {
        adj.putIfAbsent(v, new LinkedList<>());
        adj.putIfAbsent(w, new LinkedList<>());
        adj.get(v).add(w);
    }

    // A recursive function used by topologicalSort
    void topologicalSortUtil(int v, HashMap<Integer,Boolean> visited,
                             Stack stack)
    {
        System.out.println(v);
        // Mark the current node as visited.
        visited.put(v, true);
        Integer i;

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> it = adj.get(v).iterator();
        while (it.hasNext())
        {
            i = it.next();
            if (!visited.get(i)) topologicalSortUtil(i, visited, stack);
        }

        System.out.println(v);
        // Push current vertex to stack which stores result
        stack.push(v);
    }

    // The function to do Topological Sort. It uses
    // recursive topologicalSortUtil()
    void topologicalSort()
    {
        Stack stack = new Stack();

        // Mark all the vertices as not visited
        HashMap<Integer,Boolean> visited=new HashMap<>(); // Adjacency List
        for (int i : adj.keySet()) visited.put(i,false);

        // Call the recursive helper function to store
        // Topological Sort starting from all vertices
        // one by one

        for (int i : adj.keySet())
            if (visited.get(i) == false)
                topologicalSortUtil(i, visited, stack);

        // Print contents of stack
        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");
    }

    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        TopologicalSort g = new TopologicalSort(6);

       //  g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 5);
        // g.addEdge(7, 5);
        g.addEdge(6, 7);
        g.addEdge(3, 9);
        // g.addEdge(9, 5);


        System.out.println("Following is a Topological " +
                "sort of the given graph");
        g.topologicalSort();
    }
}
