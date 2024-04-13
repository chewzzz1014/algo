package progSkills;

public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // add from back (ignore the carry)
        // then normalize from back and carry forward the carry

        // calculate sum. make a reversed linked list
        int s1 = size(l1);
        int s2 = size(l2);
        ListNode resHead = null;
        ListNode n = null;
        while(l1 != null || l2 != null) {
            int v1 = 0, v2 = 0;
            if(s1 >= s2) {
                v1 = l2 != null ? l1.val : 0;
                l1 = l1.next;
                s1--;
            }
            if(s2 >= s1 + 1) { // compare with s1+1 since s1 might be decremented
                v2 = l2 != null ? l2.val : 0;
                l2 = l2.next;
                s2--;
            }
            n = new ListNode(v1 + v2);
            n.next = resHead;
            resHead = n;
        }

        // normalization (bring forward the carry and reverse back the linked list)
        // use the n (currently point to the front of reversed linked list)
        int carry = 0;
        resHead = null;
        while(n != null) {
            n.val += carry;
            if(n.val >= 10) {
                n.val = n.val % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            // reverse linked list
            ListNode next = n.next;
            n.next = resHead;
            resHead = n;
            n = next;
        }
        if (carry > 0) {
            // add node of val 1 to the front
            n = new ListNode(1);
            n.next = resHead;
            resHead = n;
        }
        return resHead;
    }

    // get the size of a linked list
    private int size(ListNode l) {
        int s = 0;
        while(l != null) {
            s++;
            l = l.next;
        }
        return s;
    }
}
