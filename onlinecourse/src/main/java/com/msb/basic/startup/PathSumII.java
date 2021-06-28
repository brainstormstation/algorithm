package com.msb.basic.startup;

import java.util.ArrayList;
import java.util.List;

import com.lintcode.common.entity.TreeNode;

/**
 * <b>Description</b>
 * <p>
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.
 * A leaf is a node with no children.
 * <p>
 * https://leetcode.com/problems/path-sum-ii/
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<Integer>();
        path.add(root.val);
        process(root, 0, targetSum, path, result);
        return result;
    }

    private void process(TreeNode node, int preSum, int targetSum, List<Integer> path, List<List<Integer>> result) {
        if (node.left == null && node.right == null) {
            if (preSum + node.val == targetSum) {
                path.add(node.val);
                result.add(copy(path));
                path.remove(path.size()-1);
            }
            return;
        }
        
        preSum += node.val;
        path.add(node.val);
        if (node.left != null ) {
            process(node.left, preSum, targetSum, path, result);
        }

        if (node.right != null) {
            process(node.right, preSum, targetSum, path, result);
        }
        path.remove(path.size()-1);
    }

    private List<Integer> copy(List<Integer> path) {
        List<Integer> res = new ArrayList<>();
        for (Integer num : path) {
            res.add(num);
        }
        return res;
    }
}
