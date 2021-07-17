package com.testutil;

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
}
