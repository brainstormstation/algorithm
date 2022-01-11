package com.enterprise.facebook.lintcode;

import java.util.*;

import com.common.entity.TreeNode;

public class Code1115_AverageOfLevelsinBinaryTree {
    /**
     * @param root: the binary tree of the  root
     * @return: return a list of double
     */
    public List<Double> averageOfLevels(TreeNode root) {
        // write your code here
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                sum+=node.val;
                if (node.left!=null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            double res = (double)sum/(double)size;
            result.add(res);
        }
        return result;
    }
}
