package com.msb.datastructure.basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import com.common.entity.Edge;
import com.common.entity.GraphNode;

public class Dijkstra {
    public HashMap<GraphNode, Integer> dijkstra(GraphNode from) {
        HashMap<GraphNode, Integer> distance = new HashMap<>();
        distance.put(from, 0);
        HashSet<GraphNode> locker = new HashSet<>();
        GraphNode minNode = getMinDistanceUnusedNode(distance, locker);
        while (minNode != null) {
            int dis = distance.get(minNode);
            for (Edge edge: minNode.edges) {
                if (distance.containsKey(edge.to)) {
                    distance.put(edge.to, Math.min(edge.weight + dis, distance.get(edge.to)));
                }
                else {
                    distance.put(edge.to, edge.weight + dis);
                }
            }

            locker.add(minNode);
            minNode = getMinDistanceUnusedNode(distance, locker);
        }
        return distance;
    }

    private GraphNode getMinDistanceUnusedNode(HashMap<GraphNode, Integer> distance, HashSet<GraphNode> locker) {
        int min = Integer.MAX_VALUE;
        GraphNode res = null;
        for (Entry<GraphNode, Integer> node : distance.entrySet()) {
            if (!locker.contains(node.getKey()) && node.getValue() < min) {
                res = node.getKey();
                min = node.getValue();
            }
        }
        return res;
    }
}
