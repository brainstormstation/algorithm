package com.msb.datastructure.system;

import java.util.*;

import com.common.entity.TreeNode;

public class TreeMaxWidth {

    public int getTreeMaxWidth(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int max = 0;
        int length = 0;
        TreeNode curEnd = head;
        TreeNode nextEnd = head;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(head);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                nextEnd = node.left;                
            }

            if (node.right != null) {
                queue.offer(node.right);
                nextEnd = node.right;
            }
            length ++;
            if (node == curEnd) {
                curEnd = nextEnd;
                max = Math.max(max, length);
                length = 0;
            }
        }
        return max;
        
    }
    
}
