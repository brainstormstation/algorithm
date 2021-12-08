package com.enterprise.facebook.leetcode;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

/**
 * Description
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors. Nodes are labeled uniquely.

You need to return a deep copied graph, which has the same structure as the original graph, and any changes to the new graph will not have any effect on the original graph.
 */
public class Code133_CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        ArrayList<Node> nodes = getAllNodes(node);
        for (Node n: nodes) {
            map.put(n, new Node(n.val));
        }

        for (Node n: nodes) {
            Node newNode = map.get(n);
            if (n.neighbors.size()!=0) {
                for (Node neighbor: n.neighbors) {
                    newNode.neighbors.add(map.get(neighbor));
                }
            }            
        }
        return map.get(node);
    }

    private ArrayList<Node> getAllNodes(Node node) {
        Stack<Node> stack = new Stack<>();
        Set<Node> set = new HashSet<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            if (set.contains(curr)) {
                continue;
            }
            set.add(curr);
            for (Node neighbor: curr.neighbors) {
                stack.push(neighbor);
            }
        }

        return new ArrayList<Node>(set);
    }
}
