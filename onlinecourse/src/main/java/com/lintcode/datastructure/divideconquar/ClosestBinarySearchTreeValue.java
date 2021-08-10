package com.lintcode.datastructure.divideconquar;

import java.util.Stack;

import com.common.entity.TreeNode;

/**
 * <b>Description</b>
 * <p>
 * Given a non-empty binary search tree and a target value, 
 * find the value in the BST that is closest to the target.
 * <ul>
 *      <li>Given target value is a floating point.</li>
 *      <li>You are guaranteed to have only one unique value in the BST that is closest to the target.</li>
 * </ul>
 * <p>
 * https://www.lintcode.com/problem/900/?_from=ladder&fromId=161
 */
public class ClosestBinarySearchTreeValue {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        // write your code here
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        if (root == null) {
            return (int)target;
        }

        int low = root.val;
        int high = root.val;
        while (root != null) {
            if (root.val > target) {
                high = root.val;
                root = root.left;
            }
            else {
                low = root.val;
                root = root.right;
            }
        }
        if (Math.abs(target - low) > Math.abs(target-high)) {
            return high;
        }
        return low;

    }
}
