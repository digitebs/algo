package model;

public class GraphNode {
    public GraphNode[] children;
    public int value;
    public boolean visited; // isword for tries implementation
    public GraphNode(int x) { value = x; }
}
