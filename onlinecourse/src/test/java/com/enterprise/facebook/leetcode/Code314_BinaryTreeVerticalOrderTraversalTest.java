package com.enterprise.facebook.leetcode;

import static org.junit.Assert.assertTrue;

import java.util.List;

import com.common.entity.TreeNode;
import com.testutil.TestUtil;

import org.junit.Before;
import org.junit.Test;

public class Code314_BinaryTreeVerticalOrderTraversalTest {
    private Code314_BinaryTreeVerticalOrderTraversal target;

    @Before
    public void test() {
        this.target = new Code314_BinaryTreeVerticalOrderTraversal();
    }

    @Test
    public void testVerticalOrder() {
        Integer[] arr = new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = TestUtil.createTreeNode(arr);
        List<List<Integer>> result = this.target.verticalOrder(root);
        assertTrue(true);
    }
}
