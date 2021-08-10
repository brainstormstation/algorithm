package com.lintcode.enterprise.bytedance;

import com.common.entity.TreeNode;

/**
 * <b>Description</b>
 * <p>
 * Given a binary search tree and a new tree node, 
 * insert the node into the tree. You should keep the tree still be a valid binary search tree.
 * <p>
 * https://www.lintcode.com/problem/85/?_from=enterprise&fromId=3
 */
public class InsertNodeInABinarySearchTree {
    /*
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) {
            return node;
        }
        if (root.val > node.val) {
            root.left = insertNode(root.left, node);
        } else {
            root.right = insertNode(root.right, node);
        }
        return root;
    }
}
