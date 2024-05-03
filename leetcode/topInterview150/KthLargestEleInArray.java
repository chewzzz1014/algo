package topInterview150;

import java.util.PriorityQueue;

public class KthLargestEleInArray {
    
    public int findKthLargest(int[] nums, int k) {
        // min-heap with max size of k
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // insert k elements
        for(int i=0; i<k; i++)
            heap.add(nums[i]);

        for(int i=k; i<nums.length; i++) {
            // if current element > smallest element in heap (top of heap)
            if(nums[i] > heap.peek()) {
                // remove top ele
                heap.poll();
                // insert current ele
                heap.add(nums[i]);
            }
        }

        return heap.peek();
    }
}
