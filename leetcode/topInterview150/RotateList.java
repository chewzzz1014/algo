package topInterview150;

public class RotateList {
    
    public ListNode rotateRight(ListNode head, int k) {
        // split into 2 parts

        if(head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = dummyHead, slow = dummyHead;

        int i;
        for (i=0; fast.next != null; i++) // Get the total length 
            fast = fast.next;

        for(int j=i-k%i; j>0; j--) // Get the i-n%i th node
            slow = slow.next;

        fast.next = dummyHead.next;
        dummyHead.next = slow.next;
        slow.next = null;

        return dummyHead.next;
    }
}
