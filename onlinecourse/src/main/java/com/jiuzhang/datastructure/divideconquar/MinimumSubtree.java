package com.jiuzhang.datastructure.divideconquar;

import com.common.entity.TreeNode;
/**
 * <b>Description</b>
 * <p>
 * Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.
 * The range of input and output data is in int.
 * <p>
 * https://www.lintcode.com/problem/596/?_from=ladder&fromId=161
 */
public class MinimumSubtree {
    class NodeSum {
        int minSum;
        TreeNode minRoot;
        public NodeSum(TreeNode minNode, int minSum) {
            this.minSum = minSum;
            this.minRoot = minNode;
        }
    }

    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        int minSum = Integer.MAX_VALUE;
        TreeNode node = null;
        NodeSum result = new NodeSum(node,minSum);
        getSum(root, result);
        return result.minRoot;
    }

    private NodeSum getSum(TreeNode root, NodeSum result) {
        if (root == null) {
            return new NodeSum(root, 0);
        }

        NodeSum left = getSum(root.left, result);
        NodeSum right = getSum(root.right, result);

        NodeSum min = new NodeSum(root, left.minSum+right.minSum+root.val);
        if (min.minSum < result.minSum) {
            result.minSum = min.minSum;
            result.minRoot = min.minRoot;
        }
        return min;
    }
}
