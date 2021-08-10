package com.msb.basic.startup;

import com.common.entity.TreeNode;

/**
 * <b>Description</b>
 * <p>
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class IsBinarySearchTree {

    public class Info {
        boolean isBST;
        int max;
        int min;

        public Info(boolean is, int ma, int mi) {
            this.isBST = is;
            this.max = ma;
            this.min = mi;
        }
    }

    public Info process(TreeNode node) {
        if (node == null) {
            return null;
        }
        Info left = process(node.left);
        Info right = process(node.right);
        int max = node.val;
        int min = node.val;

        if (left != null) {
            max = Math.max(max, left.max);
            min = Math.min(min, left.min);
        }

        if (right != null) {
            max = Math.max(max, right.max);
            min = Math.min(min, right.min);
        }
        boolean isBST = true;
        if (left !=null && !left.isBST) {
            isBST = false;
        }

        if (right != null && !right.isBST) {
            isBST = false;
        }

        boolean leftMaxLessX = left == null ? true : (left.max < node.val);
        boolean rightMinMoreX = right == null ? true : (right.min > node.val);
        if (!leftMaxLessX || !rightMinMoreX) {
            isBST = false;
        };
        return new Info(isBST, max, min);
    }
    
}
