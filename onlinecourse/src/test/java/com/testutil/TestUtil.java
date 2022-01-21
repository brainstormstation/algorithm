package com.testutil;

import java.util.*;

import com.common.entity.ListNode;
import com.common.entity.TreeNode;

public class TestUtil {

    public static TreeNode findNode(TreeNode root, TreeNode target) {
        if (root != null && root.val == target.val) {
            return root;
        }

        if (root != null) {
            TreeNode left = findNode(root.left, target);
            if (left != null) {
                return left;
            }
            TreeNode right = findNode(root.right, target);
            if (right != null) {
                return right;
            }
        }
        return null;
    }

    public static TreeNode createTreeNode(String[] arrays) {             
        TreeNode root = new TreeNode(Integer.valueOf(arrays[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty() && index<arrays.length) {
            TreeNode node = queue.poll();
            if (arrays[index]!="#") {
                node.left = new TreeNode(Integer.valueOf(arrays[index]));
                queue.offer(node.left);
            }
            index++;
            if (index<arrays.length && arrays[index]!="#") {
                node.right = new TreeNode(Integer.valueOf(arrays[index]));
                queue.offer(node.right);
            }
            index++;
        }
        return root;
    }

    public static TreeNode createTreeNode(Integer[] arr) {
        String[] strArr = new String[arr.length];
        for (int i=0; i<arr.length; i++) {
            strArr[i] = arr[i] == null?"#":String.valueOf(arr[i]);
        }
        return createTreeNode(strArr);
    }

    public static char[][] ConvertFromStringToChar(String[] strings) {
        char[][] result = new char[strings.length][strings[0].length()];
        int i = 0;
        for (String str: strings) {
            result[i++] = str.toCharArray();
        }
        return result;
    }
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
	public static ListNode generateRandomLinkedList(int len, int value) {
		int size = (int) (Math.random() * (len + 1));
		if (size == 0) {
			return null;
		}
		size--;
		ListNode head = new ListNode((int) (Math.random() * (value + 1)));
		ListNode pre = head;
		while (size != 0) {
			ListNode cur = new ListNode((int) (Math.random() * (value + 1)));
			pre.next = cur;
			pre = cur;
			size--;
		}
		return head;
	}

    public static List<Integer> getLinkedListOriginOrder(ListNode head) {
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
