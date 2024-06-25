package leetcode75;

import java.util.*;

class SmallestInfiniteSet {

    TreeSet<Integer> set;
    int smallest;
    
    public SmallestInfiniteSet() {
        set = new TreeSet<Integer>();
        smallest = 1;
    }
    
    public int popSmallest() {
        if(!set.isEmpty()) {
            int top = set.first();
            set.remove(top);
            return top;
        }
        return smallest++;
    }
    
    public void addBack(int num) {
        if(num >= smallest) return;
        set.add(num);
    }
}
