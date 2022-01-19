package com.msb.datastructure.system;

import static org.junit.Assert.assertTrue;

import java.util.*;
import com.common.entity.*;
import com.testutil.TestUtil;

import org.junit.Before;
import org.junit.Test;

public class BasicDataStructureTest {
    private BasicDataStructure target;
    @Before
    public void setup() {
        target = new BasicDataStructure();
    }

    @Test
    public void testReverseLinkedList()
    {        
        int len = 20;
        int value = 100;
        ListNode node = TestUtil.generateRandomLinkedList(len, value);
		List<Integer> list2 = TestUtil.getLinkedListOriginOrder(node);
		node = target.reverseLinkedList(node);
		for (int i = list2.size() - 1; i >= 0; i--) {
			assertTrue("Incorrect value", list2.get(i).equals(node.val));
			node = node.next;
		}
        assertTrue("True", true);
    }

    private ListNode testReverseLinkedList(ListNode head)
    {
        if (head == null) {
            return null;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        int N = list.size();
        for (int i = 1; i < N; i++) {
            list.get(i).next = list.get(i - 1);
        }
        return list.get(N - 1);
    }

    public static DoubleNode testReverseDoubleList(DoubleNode head) {
        if (head == null) {
            return null;
        }

        ArrayList<DoubleNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        DoubleNode pre = list.get(0);
        int N = list.size();
        for (int i = 1; i < N; i++) {
            DoubleNode cur = list.get(i);
            cur.pre = null;
            cur.next = pre;
            pre.pre = cur;
            pre = cur;
        }
        return list.get(N - 1);
    }
}
