package com.enterprise.facebook.leetcode;

import com.common.entity.TreeNode;

public class Code101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isEqual(root.left, root.right);
    }

    private boolean isEqual(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }

        return isEqual(left.left, right.right) && isEqual(left.right, right.left);
    }
}
