package topInterview150;

public class PartitionList {
    
    public ListNode partition(ListNode head, int x) {
        // partition to left linked list (have element <x) and right linked list (element >=x)

        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode leftCurr = left;
        ListNode rightCurr = right;

        while(head != null) {
            if(head.val < x) {
                leftCurr.next = head;
                leftCurr = leftCurr.next;
            } else {
                rightCurr.next = head;
                rightCurr = rightCurr.next;
            }
            head = head.next;
        }

        leftCurr.next = right.next;
        rightCurr.next = null;

        return left.next;
    }
}
