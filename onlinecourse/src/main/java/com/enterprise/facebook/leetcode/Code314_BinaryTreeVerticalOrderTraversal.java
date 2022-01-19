package com.enterprise.facebook.leetcode;

import java.util.*;

import com.common.entity.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 * Given the root of a binary tree, return the vertical order traversal of its nodes' values. 
 * (i.e., from top to bottom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 */
public class Code314_BinaryTreeVerticalOrderTraversal {
    class Pair {
        TreeNode node;
        int idx;
        public Pair(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Pair> queue = new LinkedList<>();
        Pair p = new Pair(root, 0);
        int minIndex = 0;
        int maxIndex = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        queue.offer(p);
        while (!queue.isEmpty()) {
            Pair pNode = queue.poll();
            minIndex = Math.min(minIndex, pNode.idx);
            maxIndex = Math.max(maxIndex, pNode.idx);
            if (map.containsKey(pNode.idx)) {
                map.get(pNode.idx).add(pNode.node.val);
            } else {
                List<Integer> record = new ArrayList<>();
                record.add(pNode.node.val);
                map.put(pNode.idx, record);
            }
            if (pNode.node.left!=null) {
                Pair lNode = new Pair(pNode.node.left, pNode.idx-1);
                queue.offer(lNode);
            }
            if (pNode.node.right != null) {
                Pair rNode = new Pair(pNode.node.right, pNode.idx+1);
                queue.offer(rNode);
            }
        }

        for (int i=minIndex; i<=maxIndex; i++) {
            result.add(map.get(i));
        }
        return result;

    }
}
