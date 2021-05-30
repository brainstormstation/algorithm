package com.datastructure.dfs;

import com.common.entity.TreeNode;

/**
 * <b>Description</b>
 * <p>
 * Invert a binary tree.Left and right subtrees exchange.
 * <p>
 * https://www.lintcode.com/problem/175/
 */
public class InvertBinaryTree {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }
}
