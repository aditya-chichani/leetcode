package com.company.topinterview.mediumcollection.graphs;

import java.util.*;

public class SingleSourceShortestPathBellmanFord {

    public static void main(String[] args) {
        int[][] times = new int[][]{{4, 2, 76}, {1, 3, 79}, {3, 1, 81}, {4, 3, 30}, {2, 1, 47}, {1, 5, 61}, {1, 4, 99}, {3, 4, 68}, {3, 5, 46}, {4, 1, 6}, {5, 4, 7}, {5, 3, 44}, {4, 5, 19}, {2, 3, 13}, {3, 2, 18}, {1, 2, 0}, {5, 1, 25}, {2, 5, 58}, {2, 4, 77}, {5, 2, 74}};
        System.out.println(new SingleSourceShortestPathBellmanFord().networkDelayTime(times, 5, 3));
    }

    private static void relax(int u, int v, int w, int[] dist) {
        long nDist = dist[u] + w;
        if (nDist < dist[v])
            dist[v] = (int) nDist;
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        // O(E) time to create Graaph
        Graaph g = new Graaph(N + 1);

        for (int i = 0; i < times.length; i++)
            g.getAdj()[times[i][0]].add(new Node(times[i][1], times[i][2]));

        // Apply your BFS Bellman Ford logic and check if it can be done in one iteration.
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        boolean[] visited = new boolean[N + 1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(K);

        while (!q.isEmpty()) {
            int u = q.poll();
            if (!visited[u]) {
                visited[u] = true;
                List<Node> edges = g.getAdj()[u];
                for (Node node : edges) {
                    q.offer(node.v);
                    relax(u, node.v, node.w, dist);
                }
            }
        }


        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++)
            if (max < dist[i])
                max = dist[i];
        return max;
    }
}


class Graaph {
    private List<Node>[] adj;

    Graaph(int n) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
    }

    public List<Node>[] getAdj() {
        return adj;
    }

}

class Node {
    int v;
    int w;

    Node(int v, int w) {
        this.v = v;
        this.w = w;
    }

}
