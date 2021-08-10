package com.leetcode.datastructure;

import java.util.ArrayList;
import java.util.List;

import com.common.entity.TreeNode;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */
public class Code94_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        process(root, result);
        return result;
    }

    private void process(TreeNode node, List<Integer> result) {
        if (node.left != null) {
            process(node.left, result);
        }
        result.add(node.val);
        if (node.right != null) {
            process(node.right, result);
        }
    }
}
