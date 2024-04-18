public class RemoveDuplicateFromSortedLinkedList {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode current = head;

        while(current != null) {
            while(current.next != null && current.val == current.next.val) {
                current = current.next;
            }
            if (prev.next == current) {
                prev = prev.next; // current.val is distinct, move prev to next node
            } else {
                prev.next = current.next; // skip duplicates, but prev shouldn't move now
            }
            current = current.next;
        }

        return dummyHead.next;
    }
    
}