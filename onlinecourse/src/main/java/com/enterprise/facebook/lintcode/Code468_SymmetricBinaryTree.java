package com.enterprise.facebook.lintcode;

import java.util.*;

import com.common.entity.*;

/**
 * Description
 * Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class Code468_SymmetricBinaryTree {
    /**
     * @param root: the root of binary tree.
     * @return: true if it is a mirror of itself, or false.
     */
    public boolean isSymmetric(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> arr = new ArrayList<>();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                arr.add(node);
                if (node !=null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                
            }
            if (!isPalindrome(arr)) {
                return false;
            }
        }
        return true;


    }

    private boolean isPalindrome(List<TreeNode> arr) {
        int start = 0, end = arr.size()-1;
        while (start < end) {
            TreeNode startNode = arr.get(start);
            TreeNode endNode = arr.get(end);
            if (startNode != null && endNode != null && startNode.val != endNode.val) {
                return false;
            }
            if (startNode != null && endNode == null) {
                return false;
            }
            if (startNode == null && endNode != null) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
