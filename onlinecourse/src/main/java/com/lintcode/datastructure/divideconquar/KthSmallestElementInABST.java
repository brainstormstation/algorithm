package com.lintcode.datastructure.divideconquar;

import java.util.Stack;
import com.lintcode.common.entity.TreeNode;
/**
 * <b>Description</b>
 * <p>
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * <p>
 * https://www.lintcode.com/problem/902/?_from=ladder&fromId=161
 */
public class KthSmallestElementInABST {
    /**
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root!= null) {
            stack.push(root);
            root = root.left;
        }
        for (int i=0; i < k-1; i++) {
            TreeNode node = stack.peek();
            if (node.right == null) {
                node = stack.pop();
                while (!stack.isEmpty() && node == stack.peek().right) {
                    node = stack.pop();
                }                
            } else {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return stack.peek().val;
    }
}
