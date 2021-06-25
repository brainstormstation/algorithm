package com.msb.basic.startup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.lintcode.common.entity.TreeNode;

/**
 * <b>Description</b>
 * <p>
 * Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (i.e., from left to right, level by level from leaf to root).
 * <p>
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class BinaryTreeLeverlOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> nodes = new ArrayList<>();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                nodes.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(0, nodes);
        }
        return result;
    }
}
