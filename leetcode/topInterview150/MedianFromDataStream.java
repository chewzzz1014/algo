package topInterview150;

import java.util.PriorityQueue;

public class MedianFromDataStream {
    
    // length of smaller half is kept to be n / 2 at all time
    // length of the larger half is either n / 2 or n / 2 + 1

    // max heap
    private PriorityQueue<Integer> small = new PriorityQueue<>((a, b) -> b-a);
    // min heap
    private PriorityQueue<Integer> large = new PriorityQueue<>();
    private boolean even = true;

    public MedianFromDataStream() {
        
    }
    
    public void addNum(int num) {
        if(even) {
            large.add(num);
            small.add(large.poll());
        } else {
            small.add(num);
            large.add(small.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if(even)
            return (small.peek() + large.peek()) / 2.0;
        else
            return small.peek();
    }
}
