package com.enterprise.facebook.lintcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.List;

import com.common.entity.TreeNode;
import com.testutil.TestUtil;

import org.junit.Before;
import org.junit.Test;

public class Code1506_AllNodesDistanceKinBinaryTreeTest {
    private Code1506_AllNodesDistanceKinBinaryTree target;

    @Before
    public void setup() {
        this.target = new Code1506_AllNodesDistanceKinBinaryTree();
    }

    @Test
    public void findDistanceK() {
        String[] arrs = new String[]{"3","5","1","6","2","0","8","#","#","7","4"};
        TreeNode root = TestUtil.createTreeNode(arrs);
        TreeNode target = new TreeNode(5);
        int dist = 2;
        TreeNode t = TestUtil.findNode(root, target);
        List<Integer> actual = this.target.distanceK(root, t, dist);
        Integer[] expected = {7,4,1};
        assertArrayEquals(expected, actual.toArray());
    }
}
