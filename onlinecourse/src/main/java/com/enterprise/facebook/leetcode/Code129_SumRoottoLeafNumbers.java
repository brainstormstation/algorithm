package com.enterprise.facebook.leetcode;

import java.util.*;

import com.common.entity.TreeNode;

public class Code129_SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> nums = new ArrayList<>();
        dfs(root, nums, 0);
        int sum = 0;
        for (int num: nums) {
            sum+=num;
        }
        return sum;
    }

    private void dfs(TreeNode node, List<Integer> nums, int num) {
        int cur = num * 10 + node.val;
        if (node.left != null) {
            dfs(node.left, nums, num);
        }

        if (node.right != null) {
            dfs(node.right, nums, num);
        }

        if (node.left == null && node.right == null) {
            nums.add(cur);
        }
    }
}
