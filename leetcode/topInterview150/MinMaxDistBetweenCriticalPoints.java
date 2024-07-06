package topInterview150;

public class MinMaxDistBetweenCriticalPoints {
    
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = {-1, -1};

        ListNode prev = head, curr = head.next;
        int idx = 1;
        int prevCriticalIndex = 0;
        int firstCriticalIndex = 0;
        int minDistance = Integer.MAX_VALUE;

        while(curr.next != null) {
            if(
                curr.val>prev.val && curr.val>curr.next.val ||
                curr.val<prev.val && curr.val<curr.next.val
            ) {
                if(prevCriticalIndex == 0) {
                    prevCriticalIndex = idx;
                    firstCriticalIndex = idx;
                } else {
                    minDistance = Math.min(minDistance, idx-prevCriticalIndex);
                    prevCriticalIndex = idx;
                }
            }
            prev = curr;
            curr = curr.next;
            idx++;
        }

        // at least 2 points found
        if(minDistance != Integer.MAX_VALUE) {
            int maxDistance = prevCriticalIndex - firstCriticalIndex;
            result = new int[] {minDistance, maxDistance};
        }

        return result;
    }
}
