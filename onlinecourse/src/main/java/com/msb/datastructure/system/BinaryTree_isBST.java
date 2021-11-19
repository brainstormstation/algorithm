package com.msb.datastructure.system;

import com.common.entity.TreeNode;

public class BinaryTree_isBST {
    class Info {
        public boolean isBST;
        int min;
        int max;
        public Info(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    public boolean isBST(TreeNode node) {
        if (node == null) {
            return true;
        }
        Info info = checkBST(node);
        return info.isBST;
    }

    private Info checkBST(TreeNode node) {
        if (node == null) {
            return null;
        }
        Info left = checkBST(node.left);
        Info right = checkBST(node.right);

        if (left != null && !left.isBST) {
            return new Info(false, 0, 0);
        }

        if (right != null && !right.isBST) {
            return new Info(false, 0, 0);
        }

        if (left != null && left.max >= node.val) {
            return new Info(false, 0, 0);
        }

        if (right != null && right.min <= node.val) {
            return new Info(false, 0, 0);
        }

        int max = node.val;
        int min = node.val;
        if (left != null ) {
            max = Math.max(max, left.max);
            min = Math.min(min, left.min);
        }

        if (right != null) {
            max = Math.max(max, right.max);
            min = Math.min(min, right.min);
        }
        return new Info(true, min, max);


    }
}
