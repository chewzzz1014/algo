package Map;

import PriorityQueue.Entry;

public class CostPerformanceDatabase {
    
    SortedMap<Integer, Integer> map = new SortedTableMap<>();

    public CostPerformanceDatabase() {

    }

    // best entry with largest cost <= c
    public Entry<Integer, Integer> best(int cost) {
        return map.floorEntry(cost);
    }

    public void add(int c, int p) {
        Entry<Integer, Integer> other = map.floorEntry(c);

        // if its performance is not that good, the new entry is ignore
        if(other != null && other.getValue() >= p)
            return;
        // else add to db
        map.put(c, p);

        // remove entries that are dominated by new one
        other = map.higherEntry(c);
        while(other != null && other.getValue()<=p) {
            map.remove(other.getKey());
            other = map.higherEntry(c);
        }
    }
    
}
