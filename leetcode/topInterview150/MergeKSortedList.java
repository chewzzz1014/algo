package topInterview150;

public class MergeKSortedList {
    
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> (a.val - b.val));

        // add linked list into heap
        for(ListNode l : lists) {
            if(l != null) {
                queue.offer(l);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(!queue.isEmpty()) {
            ListNode temp = queue.poll();
            curr.next = new ListNode(temp.val);
            curr = curr.next;
            if(temp.next != null) {
                queue.offer(temp.next); // add back the remaining elements of linked list
            }
        }

        return dummy.next;
    }
}
