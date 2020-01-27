package model;

public class GraphNode {
    public GraphNode[] children;
    public int val;
    public boolean visited; // isword for tries implementation
    public GraphNode(int x) { val = x; }
}
