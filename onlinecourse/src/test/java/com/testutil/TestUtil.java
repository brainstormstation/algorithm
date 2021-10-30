package com.testutil;

import java.util.ArrayList;
import java.util.List;

import com.common.entity.Node;
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

    // for test
	public static Node generateRandomLinkedList(int len, int value) {
		int size = (int) (Math.random() * (len + 1));
		if (size == 0) {
			return null;
		}
		size--;
		Node head = new Node((int) (Math.random() * (value + 1)));
		Node pre = head;
		while (size != 0) {
			Node cur = new Node((int) (Math.random() * (value + 1)));
			pre.next = cur;
			pre = cur;
			size--;
		}
		return head;
	}

    public static List<Integer> getLinkedListOriginOrder(Node head) {
		List<Integer> ans = new ArrayList<>();
		while (head != null) {
			ans.add(head.val);
			head = head.next;
		}
		return ans;
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
