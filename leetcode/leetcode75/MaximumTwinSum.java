package leetcode75;

public class MaximumTwinSum {
    
    public int pairSum(ListNode head) {
        int maxSum = 0;
        ListNode slow = head;
        ListNode fast = head;

        // slow refers to middle of linked list
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse second part of linked list (prev)
        ListNode nextNode;
        ListNode prev = null;
        while(slow != null) {
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        // get maxSum
        while(prev != null) {
            maxSum = Math.max(maxSum, head.val + prev.val);
            head = head.next;
            prev = prev.next;
        }

        return maxSum;
    }
}
