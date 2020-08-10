package com.company.revision.linkedlist;


import java.util.HashMap;

public class CloneListWithNextAndRandomPointers {
    public static void main(String[] args) {
        RandomListNode e = new RandomListNode(5, null);
        RandomListNode d = new RandomListNode(3, e);
        RandomListNode c = new RandomListNode(3, d, e);
        RandomListNode b = new RandomListNode(2, c);
        RandomListNode a = new RandomListNode(1, b, c);
        b.random = a;
        d.random = c;
        e.random = b;
        RandomListNode ans = cloneList(a);
        while (ans != null) {
            System.out.println("Node " + ans.val + " Random Node " + ans.random.val);
            ans = ans.next;
        }
    }

    private static RandomListNode cloneList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> oldNodeNewNodeMap = new HashMap<>();
        RandomListNode curr = head;
        RandomListNode nHead = new RandomListNode();
        RandomListNode prev = nHead;
        //O(n) time and O(n) space - Build next pointer and hashmap
        while (curr != null) {
            RandomListNode newNode = new RandomListNode(curr.val);
            oldNodeNewNodeMap.put(curr, newNode);
            prev.next = newNode;
            prev = newNode;
            curr = curr.next;
        }
        nHead = nHead.next;
        //O(n) time - Build random pointer , Can build next pointer too here - it will reduce the code till now to 2-3 lines.
        curr = head;
        RandomListNode curr2 = nHead;
        while (curr != null) {
            curr2.random = oldNodeNewNodeMap.get(curr.random);
            curr = curr.next;
            curr2 = curr2.next;
        }
        return nHead;
    }


}
