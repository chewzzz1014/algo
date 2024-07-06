package linkedlist;

public class ListNode {
    
    ListNode next;
    int val;

    ListNode() {}

    ListNode(ListNode node) {
        next = node;
    }

    ListNode(int v) {
        val = v;
    }

    ListNode(int v, ListNode node) {
        val = v;
        next = node;
    }
}
