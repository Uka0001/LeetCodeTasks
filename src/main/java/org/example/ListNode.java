package org.example;

// * Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int... vals) {
        this.val = vals[0];
        ListNode current = this;
        for (int i = 1; i < vals.length; i++) {
            current.next = new ListNode(vals[i]);
            current = current.next;
        }
    }
}
