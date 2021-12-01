package com.enterprise.facebook.leetcode;

import java.util.*;

import com.common.entity.TreeNode;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it, 
 * return the values of the nodes you can see ordered from top to bottom.
 */
public class Code199_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode curEnd = root;
        TreeNode nextEnd = root;
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                nextEnd = node.left;
            }

            if (node.right != null) {
                queue.offer(node.right);
                nextEnd = node.right;
            }

            if (node == curEnd) {
                res.add(node.val);
                curEnd = nextEnd;
            }
        }
        return res;
    }
}
