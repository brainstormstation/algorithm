package com.enterprise.facebook.lintcode;

import com.common.entity.TreeNode;

/**
 * Description
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * A single node tree is a BST
 */
public class Code95_ValidateBinarySearchTree {
    class BstResult {
        boolean flag;
        int max;
        int min;
        public BstResult (int max, int min, boolean flag) {
            this.max = max;
            this.min = min;
            this.flag = flag;
        }
    }
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }    
        
        BstResult result = isBST(root);
        return result.flag;

    }

    public BstResult isBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        BstResult left = isBST(root.left);
        BstResult right = isBST(root.right);
        if (left == null && right == null) {
            return new BstResult(root.val, root.val, true);
        }
        
        if ((left != null && !left.flag) || 
            (right != null && !right.flag)) {
            return new BstResult(0, 0, false);
        }

        if ((left != null && left.max >= root.val) ||
            (right != null && right.min <= root.val)) {
            return new BstResult(0, 0, false);
        }


        return new BstResult(right == null? root.val : Math.max(right.max, root.val), left == null? root.val : Math.min(left.min, root.val), true);

    }
}
