package com.enterprise.facebook.lintcode;

import java.util.*;

import com.common.entity.TreeNode;

/**
 * Description
 * Flatten a binary tree to a fake "linked list" in pre-order traversal.
 * Here we use the right pointer in TreeNode as the next pointer in ListNode.
 */
public class Code453_FlattenBinaryTreeToLinkedList {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right!=null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }

            node.left = null;
            if (stack.isEmpty()) {
                node.right = null;
            } else {
                node.right = stack.peek();
            }

        }
    }
}
