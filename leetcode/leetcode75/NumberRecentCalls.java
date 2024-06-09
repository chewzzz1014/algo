package leetcode75;

import java.util.TreeSet;

public class NumberRecentCalls {
    TreeSet<Integer> ts;

    public NumberRecentCalls() {
        ts = new TreeSet<>();    
    }
    
    public int ping(int t) {
        ts.add(t);
        return ts.tailSet(t - 3000).size();
    }
}
