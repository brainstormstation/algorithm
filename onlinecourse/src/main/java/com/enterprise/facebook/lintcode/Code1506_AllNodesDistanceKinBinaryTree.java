package com.enterprise.facebook.lintcode;

import java.util.*;

import com.common.entity.TreeNode;

/**
 * Description
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 * Return a list of the values of all nodes that have a distance K from the target node. The answer can be returned in any order.
 *  <ul>
 *  <li>The given tree is non-empty and has k nodes at most.</li>
 *  <li>Each node in the tree has unique values 0 <= node.val <= 500.</li>
 *  <li>The target node is a node in the tree.</li>
 *  <li>0 <= K <= 1000.</li>
 *  </ul>
 */
public class Code1506_AllNodesDistanceKinBinaryTree {
    /**
     * @param root: the root of the tree
     * @param target: the target
     * @param K: the given K
     * @return: All Nodes Distance K in Binary Tree
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Set<TreeNode> seen = new HashSet<>();        
        Queue<TreeNode> queue = new LinkedList<>();
        int dist = 0;
        queue.offer(null);
        queue.offer(target);
        seen.add(null);
        seen.add(target);
        dfs(root, null, parent);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (dist == K) {
                    for (TreeNode n: queue) {
                        result.add(n.val);
                    }
                    return result;
                }
                dist++;
                queue.offer(null);
            } else {
                if (!seen.contains(node.left)) {
                    seen.add(node.left);
                    queue.offer(node.left);
                }
                if (!seen.contains(node.right)) {
                    seen.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode p = parent.get(node);
                if (!seen.contains(p)) {
                    seen.add(p);
                    queue.offer(p);
                }
                
            }
        }
        return result;

    }

    private void dfs(TreeNode node, TreeNode parentNode, Map<TreeNode, TreeNode> parent) {
        if (node != null) {
            parent.put(node, parentNode);
            dfs(node.left, node, parent);
            dfs(node.right, node, parent);
        }
    }
}
