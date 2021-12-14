package com.enterprise.facebook.lintcode;

import java.util.*;

import com.common.entity.TreeNode;

/**
 * Description
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 */
public class Code1353_SumRoottoLeafNumbers {
    /**
     * @param root: the root of the tree
     * @return: the total sum of all root-to-leaf numbers
     */
    public int sumNumbers(TreeNode root) {
        // write your code here
        List<Integer> nums = new ArrayList<>();
        dfs(root, nums, 0);
        int sum = 0;
        for (int num: nums) {
            sum+=num;
        }
        return sum;
    }

    private void dfs(TreeNode node, List<Integer> nums, int num) {
        if (node == null) {
            return;
        }

        int curr = num*10+node.val;
        if (node.left!=null) {
            dfs(node.left, nums, curr);
        }

        if (node.right != null) {
            dfs(node.right, nums, curr);
        }

        if (node.left== null && node.right == null) {
            nums.add(curr);
        }
    }
}
