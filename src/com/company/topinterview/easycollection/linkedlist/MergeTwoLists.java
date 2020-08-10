package com.company.topinterview.easycollection.linkedlist;

public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(2, a);
        ListNode c = new ListNode(1, b);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(3, d);
        ListNode f = new ListNode(1, e);
        System.out.println(mergeTwoLists(c, f));

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tmp, curr = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmp = l1;
                l1 = l1.next;
                tmp.next = null;
                curr.next = tmp;
                curr = curr.next;
            } else {
                tmp = l2;
                l2 = l2.next;
                tmp.next = null;
                curr.next = tmp;
                curr = curr.next;
            }
        }

        if (l1 == null)
            curr.next = l2;
        else curr.next = l1;

        return head.next;
    }


    static ListNode mergeLists(ListNode head1, ListNode head2) {
        ListNode curr1 = head1, curr2 = head2;
        ListNode head = new ListNode();
        ListNode curr = head;
        while (curr1 != null && curr2 != null) {
            if (curr1.val < curr2.val) {
                curr.next = curr1;
                curr1 = curr1.next;
                curr = curr.next;
                curr.next = null;
            } else {
                curr.next = curr2;
                curr2 = curr2.next;
                curr = curr.next;
                curr.next = null;
            }
        }
        if (curr1 != null) {
            curr.next = curr1;
        }
        if (curr2 != null) {
            curr.next = curr2;
        }
        return head.next;
    }
}
