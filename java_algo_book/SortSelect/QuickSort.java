package SortSelect;

import Queue.LinkedQueue;
import Queue.Queue;
import java.util.Comparator;

public class QuickSort<K> {
    
    public static <K> void quickSort(Queue<K> S, Comparator<K> comparator) {
        int n = S.size();
        if(n < 2) return;

        // divide
        K pivot = S.first();
        Queue<K> L = new LinkedQueue<>();
        Queue<K> E = new LinkedQueue<>();
        Queue<K> G = new LinkedQueue<>();

        while(!S.isEmpty()) {
            K element = S.dequeue();
            int c = comparator.compare(pivot, element);
            if(c < 0)
                L.enqueue(element);
            else if(c == 0)
                E.enqueue(element);
            else
                G.enqueue(element);
        }

        // conquer
        quickSort(L, comparator);
        quickSort(G, comparator);

        // contact results
        while(!L.isEmpty())
            S.enqueue(L.dequeue());
        while(!E.isEmpty())
            S.enqueue(E.dequeue());
        while(!G.isEmpty())
            S.enqueue(G.dequeue());
    }
}
