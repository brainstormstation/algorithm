package com.testutil;

import com.common.entity.TreeNode;
import com.lintcode.common.entity.ListNode;

public class TestUtil {
    public static void printArr(int[] arr) {
        for (int i: arr) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public static int[] generateRandomArray(int size, int maxValue) {
        int[] arr = new int[size];
        for (int i=0; i<arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }

    public static ListNode generateRandomLinkList(int size, int maxValue) {
        int[] arr = generateRandomArray(size, maxValue);
        ListNode cur = new ListNode(arr[0]);
        ListNode head = cur;
        for (int i = 1; i < arr.length; i++) {
            ListNode next = new ListNode(arr[i]);
            cur.next = next;
            cur = cur.next;
        }
        return head;
    }

    public static TreeNode generateBinaryTree(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    private static TreeNode generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        TreeNode head = new TreeNode((int)(maxValue * Math.random()));
        head.left = generate(level+1, maxLevel, maxValue);
        head.right = generate(level+1, maxLevel, maxValue);
        return head;
    }
}
