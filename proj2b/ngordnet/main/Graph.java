package ngordnet.main;

import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;
import java.util.HashSet;


public class Graph<T> {
    private int vertices;
    private int V;
    private List<Edge> edges;
    //private List<T>[] adj;
    private HashMap<Integer, HashSet<T>> adj;

    public Graph (int V, HashMap map) {
        this.V = V;
        //adj = (List<T>[]) new ArrayList[V];
        adj = new HashMap<Integer, HashSet<T>>();
        for (int v = 0; v < V; v++) {
            adj.put(v, new HashSet<T>());
        }
    }



    public class Edge {
        private T start;
        private T end;
        public Edge(T start, T end) {
            this.start = start;
            this.end = end;

        }
    }
    public void addEdge(T v, T w) {
        if (!adj.get(v).contains(w)) {
            Edge newedge = new Edge(v,w);
            adj.get(v).add(w);
            edges.add(newedge);
        }

    }

    public Iterable<T> adj(int v) {
        return adj.get(v);
    }
    public int V() {
        return V;
    }
    public int E() {
        return edges.size();
    }





}
