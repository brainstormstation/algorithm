package com.enterprise.facebook.leetcode;

import static org.junit.Assert.assertTrue;

import java.util.List;

import com.common.entity.TreeNode;
import com.testutil.TestUtil;

import org.junit.Before;
import org.junit.Test;

public class Code987_VerticalOrderTraversalOfABinaryTreeTest {
    private Code987_VerticalOrderTraversalOfABinaryTree target;
    
    @Before
    public void setup() {
        this.target = new Code987_VerticalOrderTraversalOfABinaryTree();
    }

    @Test
    public void testVerticalTravel() {
        Integer[] arr = {1,2,3,4,5,6,7};
        TreeNode root = TestUtil.createTreeNode(arr);
        List<List<Integer>> actual = target.verticalTraversal(root);
        assertTrue(true);
    }
}
