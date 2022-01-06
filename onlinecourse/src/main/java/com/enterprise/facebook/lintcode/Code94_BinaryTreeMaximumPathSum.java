package com.enterprise.facebook.lintcode;

import com.common.entity.TreeNode;

/**
 * Description
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * (Path sum is the sum of the weights of nodes on the path between two nodes.)
 */
public class Code94_BinaryTreeMaximumPathSum {
    private int max = Integer.MIN_VALUE;

    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public int maxPathSum(TreeNode root) {        
        getSum(root);
        return max;
    }

    private int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getSum(root.left);
        int right = getSum(root.right);

        int curMax = Math.max(Math.max(left+root.val, right+root.val), root.val);
        max = Math.max(max, Math.max(curMax, left + right+ root.val));
        return curMax;
    }
}
