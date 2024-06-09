package leetcode75;

public class DeleteMiddleNodeLinkedList {
    
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;
        return head;
    }
}
