package graph;

import java.util.ArrayList;

/**
 * Created by johnlim on 11/5/16.
 */
public class GraphVertexEdge {
    public static class Edge{
        Vertex source;
        Vertex terminal;
    }
    public static class Vertex{
        ArrayList<Edge> outgoing=new ArrayList<>();
        ArrayList<Edge> incoming=new ArrayList<>();
    }


    //dfs
    public static void traverse(Vertex source,Vertex dest,ArrayList path,ArrayList minPath){

    if(source ==null || path.contains(source))
            return;

        path.add(source);
        if(source==dest) {
            minPath.clear();
            minPath.addAll(path);
            return;
        }

        for (Edge edge: source.outgoing) {

            if (minPath.size()==0 || path.size() < minPath.size()) {
                ArrayList currentPath = new ArrayList();
                currentPath.addAll(path);
                traverse(edge.terminal, dest, currentPath, minPath);
            }
        }
    }

    public static void main(String[] args){
        Vertex v1 = new GraphVertexEdge.Vertex();
        Vertex v2 = new GraphVertexEdge.Vertex();
        Vertex v3 = new GraphVertexEdge.Vertex();
        Vertex v4 = new GraphVertexEdge.Vertex();

        Edge e1 = new GraphVertexEdge.Edge();
        e1.source=v1;
        e1.terminal=v2;

        Edge e4= new GraphVertexEdge.Edge();
        e4.source=v1;
        e4.terminal=v4;


        v1.outgoing.add(e1);
        v1.outgoing.add(e4);

        Edge e2= new GraphVertexEdge.Edge();
        e2.source=v2;
        e2.terminal=v3;

        v2.outgoing.add(e2);

        Edge e3= new GraphVertexEdge.Edge();
        e3.source=v3;
        e3.terminal=v4;

        v3.outgoing.add(e3);

        ArrayList path = new ArrayList();
        ArrayList minPath = new ArrayList();
        //graph.GraphVertexEdge.assign(minPath);
        GraphVertexEdge.traverse(v1,v1,path,minPath);

        System.out.println(minPath);

    }
}
