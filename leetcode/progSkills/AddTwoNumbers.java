package progSkills;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0); // dummy node in new linked list
        ListNode curr = newHead;
        int carry = 0;

        while(l1 != null || l2 != null || carry == 1) {
            int currentSum = 0;
            if(l1 != null) {
                currentSum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                currentSum += l2.val;
                l2 = l2.next;
            }

            currentSum += carry;
            carry = currentSum/10; // if currentSum>10, get the carry
            ListNode node = new ListNode(currentSum % 10); // get the sum where <10
            curr.next = node; // add new node to the end
            curr = curr.next;
        }
        return newHead.next; // skip the first dummy node
    }
}
