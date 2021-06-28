package com.msb.basic.startup;

import com.lintcode.common.entity.TreeNode;

public class PathSum {
    
    boolean flag = false;
    public boolean hasPathSum(TreeNode node, int sum) {
        if (node == null) {
            return flag;
        }
        process(node, 0, sum);
        return flag;
    }

    private void process(TreeNode node, int preSum, int sum) {
        if (node.left == null && node.right == null) {
            if (preSum + node.val == sum) {
                flag = true;
            }
            return;
        }

        preSum += node.val;
        if (node.left != null) {
            process(node.left, preSum, sum);
        }

        if (node.right != null) {
            process(node.right, preSum, sum);
        }
    }
}
