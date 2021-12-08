package com.enterprise.facebook.lintcode;

import java.util.*;

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
/**
 * Description
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors. 
 * Nodes are labeled uniquely.
 * You need to return a deep copied graph, which has the same structure as the original graph, 
 * and any changes to the new graph will not have any effect on the original graph.
 */
public class Code137_CloneGraph {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return null;
        }
        
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        List<UndirectedGraphNode> nodes = getNodes(node);
        for (UndirectedGraphNode curr: nodes) {
            map.put(curr, new UndirectedGraphNode(curr.label));
        }

        for (UndirectedGraphNode curr: nodes) {
            UndirectedGraphNode newCurr = map.get(curr);
            for (UndirectedGraphNode neighbor: curr.neighbors) {
                newCurr.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }   

    private List<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Stack<UndirectedGraphNode> stack = new Stack<>();
        stack.push(node);
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        while (!stack.isEmpty()) {
            UndirectedGraphNode curr = stack.pop();
            if (set.contains(curr)) {
                continue;
            }
            set.add(curr);
            for (UndirectedGraphNode neighbor: curr.neighbors) {
                stack.push(neighbor);
            }
        }
        return new ArrayList<UndirectedGraphNode>(set);
    }
}
