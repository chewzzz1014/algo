package progSkills;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        // another linked list
        ListNode newHead = null;

        while(head != null) {
            ListNode next = head.next;
            // add head to front of new linked list
            head.next = newHead;
            newHead = head;
            // move head pointer
            head = next;
        }
        return newHead;
    }
}
