package com.datastructure.dfs;

import com.common.entity.TreeNode;

/**
 * <b>Description</b>
 * <p>
 * Given a binary tree, find the subtree with maximum average. Return the root of the subtree.
 * <p>
 * https://www.lintcode.com/problem/597/
 */
public class SubtreeWithMaximumAverage {
    private class Result {
        int sum;
        int num;
        public Result(int num, int sum) {
            this.sum = sum;
            this.num = num;
        }
    }

    private TreeNode maxAverage = null;
    private Result maxResult = null;
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        dfs(root);
        return this.maxAverage;
    }

    private Result dfs(TreeNode node) {
        if (node == null) {
            return new Result(0,0);
        }

        Result left = dfs(node.left);
        Result right = dfs(node.right);
        Result result = new Result(left.sum+right.sum+node.val, left.num+right.num+1);
        if (maxAverage == null || maxResult.num * result.sum > maxResult.sum * result.num) {
            maxAverage = node;
            maxResult = result;
        }
        return result;

    }
}
