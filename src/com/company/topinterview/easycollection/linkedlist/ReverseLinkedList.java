package com.company.topinterview.easycollection.linkedlist;

public class ReverseLinkedList {
    static ListNode nHead;

    private static ListNode reverseListHelper(ListNode head) {
        if (head.next == null) {
            nHead = head;
            return head;
        }
        reverseListHelper(head.next).next = head;
        head.next = null;
        return head;
    }

    public ListNode reverseList(ListNode head) {
        ListNode tail = null, tmp;
        while (head != null) {
            tmp = head;
            head = head.next;
            tmp.next = tail;
            tail = tmp;
        }
        return tail;
    }

    public ListNode reverseListUsingRecursion(ListNode head) {
        nHead = null;
        if (head != null)
            reverseListHelper(head);
        return nHead;
    }
}
