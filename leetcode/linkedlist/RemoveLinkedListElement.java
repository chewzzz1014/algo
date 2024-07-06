package linkedlist;

public class RemoveLinkedListElement {
    public ListNode removeElements(ListNode head, int val) {
        // Approach 1: delete inplace
        // need to consider edge case where head needed to be deleted
        while(head != null && head.val == val) {
            head = head.next;
        }
        ListNode curr = head;
        while(curr != null && curr.next != null) {
            if(curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;

        // Approach 2: virtual head
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;

        while(head != null) {
            if(head.val != val) {
                curr.next = new ListNode(head.val);
                curr = curr.next;
            }
            head = head.next;
        }
        return dummyHead.next;
    }
}
