package topInterview150;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        /**
        * Reverse a link list between begin and end exclusively
        * an example:
        * a linked list:
        * 0->1->2->3->4->5->6
        * |           |   
        * begin       end
        * after call begin = reverse(begin, end)
        * 
        * 0->3->2->1->4->5->6
        *          |  |
        *      begin end
        * @return the reversed list's 'begin' node, which is the precedence of node end
        */
        ListNode begin;
        if(head == null || head.next == null || k==1)
            return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        begin = dummyHead;
        int i = 0;

        while(head != null) {
            i++;
            if(i%k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummyHead.next;
    }

    public ListNode reverse(ListNode begin, ListNode end) {
        ListNode current = begin.next;
        ListNode next, first;
        ListNode prev = begin;
        first = current;

        while(current != end) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        begin.next = prev;
        first.next = current;
        return first;
    }
}
