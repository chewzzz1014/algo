package SortSelect;

import java.util.Comparator;

import Queue.LinkedQueue;
import Queue.Queue;

public class MergeSortLinkedList<K> {
    
    public static <K> void merge(Queue<K> Q1, Queue<K> Q2, Queue<K> Q, Comparator<K> comparator) {
        while(!Q1.isEmpty() && !Q2.isEmpty()) {
            if(comparator.compare(Q1.first(), Q2.first()) < 0)
                Q.enqueue(Q1.dequeue());
            else
                Q.enqueue(Q2.dequeue());
        }
        while(!Q1.isEmpty())
            Q.enqueue(Q1.dequeue());
        while(!Q2.isEmpty())
            Q.enqueue(Q2.dequeue());
    }

    public static <K> void mergeSort(Queue<K> Q, Comparator<K> comparator) {
        int n = Q.size();
        if(n < 2) return;

        Queue<K> Q1 = new LinkedQueue<>();
        Queue<K> Q2 = new LinkedQueue<K>();
        while(Q1.size() < n/2) // first half
            Q1.enqueue(Q.dequeue());
        while(!Q.isEmpty())
            Q2.enqueue(Q.dequeue());
        
        mergeSort(Q1, comparator);
        mergeSort(Q2, comparator);

        merge(Q1, Q2, Q, comparator);
    }
}
