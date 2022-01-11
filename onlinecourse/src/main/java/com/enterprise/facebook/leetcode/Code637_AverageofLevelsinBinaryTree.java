package com.enterprise.facebook.leetcode;

import java.util.*;

import com.common.entity.TreeNode;

public class Code637_AverageofLevelsinBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            long size = queue.size();
            long sum = 0;
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left!=null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

            }
            result.add(sum * 1.0/size);
        }
        return result;
    }
}
