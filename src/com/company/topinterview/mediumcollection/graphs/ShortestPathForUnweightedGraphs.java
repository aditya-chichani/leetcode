package com.company.topinterview.mediumcollection.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathForUnweightedGraphs {
    public static void main(String[] args) {
        Graph g = Graph.getDefaultGraph();
        int[] distance = computeShortestPathForUnweightedGraphs(g, 0);
        System.out.println(Arrays.toString(distance));
    }

    private static int[] computeShortestPathForUnweightedGraphs(Graph g, int start) {
        int[] distance = new int[g.getV()];
        distance[start] = 0;
        boolean[] visited = new boolean[g.getV()];
        visited[start] = true;
        Queue<Integer> bfs = new LinkedList<>();
        bfs.offer(start);
        while (!bfs.isEmpty()) {
            Integer v = bfs.poll();
            List<Integer> neighbors = g.getAdj().get(v);
            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[v] + 1;
                    bfs.offer(neighbor);
                }
            }
        }
        return distance;
    }
}
