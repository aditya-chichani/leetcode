package com.company.miscellanous;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
    static Map<Integer, GraphNode> isVisited;

    /*
    Runtime: 25 ms, faster than 99.64% of Java online submissions for Clone Graph.
    Memory Usage: 39.8 MB, less than 5.88% of Java online submissions for Clone Graph.
     */

    private static GraphNode bfs(GraphNode graphNode) {
        Queue<GraphNode> toBeVisited = new LinkedList<>();
        toBeVisited.offer(graphNode);

        while (!toBeVisited.isEmpty()) {
            GraphNode curr = toBeVisited.poll();
            GraphNode currClone = isVisited.getOrDefault(curr.val, new GraphNode(curr.val));
            isVisited.put(curr.val, currClone);

            for (GraphNode neighbor : curr.neighbors) {
                GraphNode clone;
                if (!isVisited.containsKey(neighbor.val)) {
                    clone = new GraphNode(neighbor.val);
                    isVisited.put(neighbor.val, clone);
                    toBeVisited.offer(neighbor);
                } else clone = isVisited.get(neighbor.val);
                currClone.neighbors.add(clone);
            }
        }

        return isVisited.get(graphNode.val);
    }

    private static GraphNode dfs(GraphNode graphNode) {
        if (isVisited.containsKey(graphNode.val))
            return isVisited.get(graphNode.val);

        GraphNode newGraphNode = new GraphNode(graphNode.val);
        isVisited.put(graphNode.val, newGraphNode);

        for (GraphNode neighbor : graphNode.neighbors) {
            newGraphNode.neighbors.add(dfs(neighbor));
        }

        return newGraphNode;
    }

    /*
    Runtime: 27 ms, faster than 72.90% of Java online submissions for Clone Graph.
    Memory Usage: 40 MB, less than 5.88% of Java online submissions for Clone Graph.
    */

    public GraphNode cloneGraphUsingBFS(GraphNode graphNode) {
        if (graphNode == null)
            return graphNode;
        isVisited = new HashMap<>();
        return bfs(graphNode);
    }

    public GraphNode cloneGraphUsingDFS(GraphNode graphNode) {
        if (graphNode == null)
            return graphNode;
        isVisited = new HashMap<>();
        return dfs(graphNode);
    }
}
