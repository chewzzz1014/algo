package PriorityQueue;

import List.PositionalList;

public class PQSort<T> {
    
    public static <T> void pqSort(PositionalList<T> S, PriorityQueue<T, ?> P) {
        int n = S.size();
        // add all elements in S into heap (ascending order)
        for(int i=0; i<n; i++) {
            T element = S.remove(S.first());
            P.insert(element, null);
        }
        // remove from P and add to S
        for(int i=0; i<n; i++) {
            T element = P.removeMin().getKey();
            S.addLast(element);
        }
    }
}
