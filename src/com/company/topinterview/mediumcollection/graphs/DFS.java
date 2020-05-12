package com.company.topinterview.mediumcollection.graphs;

import java.util.List;

public class DFS {
    // A function used by DFS
    void DFSUtil(Graph g, int v, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");
        // Recur for all the vertices adjacent to this vertex
        List<Integer> neighbors = g.getAdj().get(v);
        for (int neighbor : neighbors) {
            if (!visited[neighbor])
                DFSUtil(g, neighbor, visited);
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int start, Graph g) {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean[] visited = new boolean[g.getV()];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(g, start, visited);
    }
}
