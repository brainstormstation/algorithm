package com.datastructure.dfs;

import javax.naming.spi.DirStateFactory.Result;

import com.common.entity.TreeNode;

/**
 * <b>Description</b>
 * <p>
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * <ul>
 * <li>The left subtree of a node contains only nodes with keys less than the node's key.</li>
 * <li>The right subtree of a node contains only nodes with keys greater than the node's key.</li>
 * <li>Both the left and right subtrees must also be binary search trees.</li>
 * <li>A single node tree is a BST</li>
 * </ul>
 */
public class ValidateBinarySearchTree {
    class ResultType {
        boolean isBST;
        TreeNode minNode;
        TreeNode maxNode;
        public ResultType(boolean isBST) {
            this.isBST = isBST;
        }
    }
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        return divideConquer(root).isBST;
    }

    private ResultType divideConquer(TreeNode node) {
        if (node == null) {
            return new ResultType(true);
        }

        ResultType left = divideConquer(node.left);
        ResultType right = divideConquer(node.right);

        if (!left.isBST || !right.isBST) {
            return new ResultType(false);
        }

        if (left.maxNode != null && left.maxNode.val >= node.val) {
            return new ResultType(false);
        }

        if (right.minNode != null && right.minNode.val <= node.val) {
            return new ResultType(false);
        }
        ResultType result = new ResultType(true);
        result.minNode = left.minNode != null ? left.minNode : node;
        result.maxNode = right.maxNode != null ? right.maxNode : node;
        return result;
    }
}
