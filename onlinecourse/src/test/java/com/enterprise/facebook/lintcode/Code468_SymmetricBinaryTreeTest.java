package com.enterprise.facebook.lintcode;

import static org.junit.Assert.assertEquals;

import com.common.entity.TreeNode;

import org.junit.Before;
import org.junit.Test;

public class Code468_SymmetricBinaryTreeTest {
    private Code468_SymmetricBinaryTree target;

    @Before
    public void setup() {
        this.target = new Code468_SymmetricBinaryTree();
    }

    @Test
    public void testMethod() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        boolean result = this.target.isSymmetric(root);
        assertEquals(false, result);
    }
}
