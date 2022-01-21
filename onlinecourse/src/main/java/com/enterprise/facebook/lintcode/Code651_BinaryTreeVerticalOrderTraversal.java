package com.enterprise.facebook.lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.common.entity.TreeNode;

/**
 * Description
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 */
public class Code651_BinaryTreeVerticalOrderTraversal {
    class Pair {
        TreeNode node;
        int key;
        public Pair(TreeNode node, int key) {
            this.node = node;
            this.key = key;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // write your code hereSubarray Sum Equals K
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Pair pRoot = new Pair(root, 0);
        int minIndex = 0, maxIndex = 0;
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            Pair pNode = queue.poll();
            TreeNode node = pNode.node;
            int key = pNode.key;
            minIndex = Math.min(minIndex, key);
            maxIndex = Math.max(maxIndex, key);
            if (map.containsKey(key)) {
                map.get(key).add(node.val);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                map.put(key, list);
            }

            if (node.left != null) {
                queue.offer(new Pair(node.left, key-1));
            }

            if (node.right != null) {
                queue.offer(new Pair(node.right, key+1));
            }
        }

        for (int i= minIndex; i<=maxIndex; i++) {
            result.add(map.get(i));
        }
        return result;
    }
}
