package ngordnet.main;

import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;
import java.util.HashSet;


public class Graph<T> {
    private int vertices;
    private List<Edge> edges;
    private List<List<Node>> adj = new ArrayList<>();



    private class Node {
        private T word;
        public Node(T word) {
            this.word = word;
        }
    }


    public Graph (List<Edge> edges) {
        this.edges = edges;
        for (int i = 0; i < edges.size(); i++) {
            adj.add(i, new ArrayList<>());
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
        for (Edge edge: edges) {
        adj.get(edge.start).add(new Node(edge.end));
        }
    }
    public Iterable<T> adj(int v) {
        return adj[v];
    }
    public int V() {
        return V;
    }
    public int E() {
        return edges.size();
    }





}
