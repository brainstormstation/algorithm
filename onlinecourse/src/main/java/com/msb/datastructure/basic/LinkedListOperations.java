package com.msb.datastructure.basic;

import java.util.HashMap;

import com.lintcode.common.entity.DoubleNode;
import com.lintcode.common.entity.ListNode;

public class LinkedListOperations {
    public ListNode reverseLinkList(ListNode node) {
        ListNode pre = null;
        ListNode next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    public DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public void removeListNode(ListNode head, int target) {
        ListNode pre = null;
        while (head != null) {
            if (head.val == target) {
                break;
            }
            pre = head;
            head = head.next;
        }

        if (head != null) {
            pre.next = head.next;
            head = null;
        }

    }

    public ListNode getMidOrUpMidNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast.next != null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    public ListNode getMidOrDownMidNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode n1 = head;
        ListNode n2 = head;
        // Find the mid node
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next;
        n1.next = null;
        ListNode  n3 =  null;
        // Reverse list
        while(n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1.next;
        n2 = head;
        boolean res = true;
        while (n1 != null && n2 != null) {
            if(n1.val != n2.val) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        // Reverse back the list
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

    public ListNode partition(ListNode  head, int target) {
        if (head == null) {
            return head;
        }
        ListNode next = null;
        // less 
        ListNode lh = null;
        ListNode lt = null;

        // equal
        ListNode eh = null;
        ListNode et = null;

        // more
        ListNode mh = null;
        ListNode mt = null;

        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < target) {
                if (lh == null) {
                    lh = head;
                }
                if (lt != null) {
                    lt.next = head;
                }
                lt = head;
            }
            else if (head.val == target) {
                if (eh == null) {
                    eh = head;
                }
                if (et != null) {
                    et.next = head;
                }
                et = head;
            }
            else if (head.val > target) {
                if (mh == null) {
                    mh = head;
                }
                if (mt != null) {
                    mt.next = head;
                }
                mt = head;
            }
            head = next;
        }

        if (lt!=null) {
            lt.next = eh;
            et = et == null ? lt : et;
        }

        if (et != null) {
            et.next = mh;
        }

        return lh != null? lh : ( eh != null? eh : mh );       

    }

    public ListNode copyLinkedList1(ListNode head) {
        ListNode cur = head;
        HashMap<ListNode, ListNode> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new ListNode(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            cur = cur.next;
        }
        return map.get(head);

    }
    
}
