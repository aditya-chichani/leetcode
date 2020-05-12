package com.company.topinterview.mediumcollection.graphs;

// Java program to print DFS traversal from a given given graph

import java.util.LinkedList;
import java.util.List;

// This class represents a directed graph using adjacency list
// representation
public class Graph {
    private int V; // No. of vertices

    // Array of lists for Adjacency List Representation
    private List<List<Integer>> adj;

    Graph() {

    }

    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList();
        for (int i = 0; i < v; ++i)
            adj.add(new LinkedList());
    }

    public static Graph getDefaultGraph() {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        return g;
    }

    public int getV() {
        return V;
    }

    public void setV(int v) {
        V = v;
    }

    public List<List<Integer>> getAdj() {
        return adj;
    }

    public void setAdj(List<List<Integer>> adj) {
        this.adj = adj;
    }

    //Function to add an edge into the graph
    public void addEdge(int v, int w) {
        adj.get(v).add(w); // Add w to v's list.
    }
}

