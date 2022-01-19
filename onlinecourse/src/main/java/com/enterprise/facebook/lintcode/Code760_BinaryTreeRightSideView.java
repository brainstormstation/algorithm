package com.enterprise.facebook.lintcode;

import java.util.*;

import com.common.entity.TreeNode;

public class Code760_BinaryTreeRightSideView {
    /**
     * @param root: the root of the given tree
     * @return: the values of the nodes you can see ordered from top to bottom
     */
    public List<Integer> rightSideView(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (i==size-1) {
                    result.add(node.val);
                }
            }
        }
        return result;
    }
}
