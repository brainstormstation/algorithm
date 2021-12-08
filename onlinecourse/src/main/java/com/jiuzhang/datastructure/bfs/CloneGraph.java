package com.jiuzhang.datastructure.bfs;

import java.util.*;

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}
/**
 * <b>Description</b>
 * <p>
 * Clone an undirected graph. 
 * Each node in the graph contains a label and a list of its neighbors. 
 * Nodes are labeled uniquely.
 * You need to return a deep copied graph, 
 * which has the same structure as the original graph, 
 * and any changes to the new graph will not have any effect on the original graph.
 * <p>
 * https://www.lintcode.com/problem/137/?_from=ladder&fromId=161
 */
public class CloneGraph {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }

        ArrayList<UndirectedGraphNode> nodes = getNodes(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

        for (UndirectedGraphNode n: nodes) {
            map.put(n, new UndirectedGraphNode(n.label));
        }

        for (UndirectedGraphNode n: nodes) {
            UndirectedGraphNode newNode = map.get(n);
            for (UndirectedGraphNode neighbor: n.neighbors) {
                UndirectedGraphNode newNeighor = map.get(neighbor);
                newNode.neighbors.add(newNeighor);
            }
        }
        return map.get(node);
    }

    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();

        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for (UndirectedGraphNode neighbor: head.neighbors) {
                if (!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
