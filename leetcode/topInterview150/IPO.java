package topInterview150;

import java.util.PriorityQueue;

public class IPO {
    
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // min heap
        PriorityQueue<int[]> capitalHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        // max heap
        PriorityQueue<int[]> profitHeap = new PriorityQueue<>((a, b) -> (b[1] - a[1]));

        // add every entry into capitalHeap
        for(int i = 0; i<profits.length; i++)
            capitalHeap.add(new int[] {capital[i], profits[i]});

        // only work on k # project
        for(int i=0; i<k; i++) {
            // add projects with capital<=w
            while(!capitalHeap.isEmpty() && capitalHeap.peek()[0] <= w) {
                profitHeap.add(capitalHeap.poll());
            }

            if(profitHeap.isEmpty()) break;

            // work on project with max profit
            w += profitHeap.poll()[1];
        }

        return w;
    }
}
