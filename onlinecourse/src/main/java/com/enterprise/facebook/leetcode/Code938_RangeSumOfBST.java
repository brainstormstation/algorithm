package com.enterprise.facebook.leetcode;

import com.common.entity.TreeNode;

/**
 * Given the root node of a binary search tree and two integers low and high, 
 * return the sum of values of all nodes with a value in the inclusive range [low, high].
 */
public class Code938_RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int leftSum = rangeSumBST(root.left, low, high);
        int rightSum = rangeSumBST(root.right, low, high);
        int val = root.val<low||root.val>high?0:root.val;
        return leftSum+rightSum+val;
    }
    
}
