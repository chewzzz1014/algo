package topInterview150;

import java.util.LinkedList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new LinkedList<>();
        
        for(int[] interval : intervals) {
            // if the newInterval is smaller than current interval
            if(newInterval[1] < interval[0]) {
                result.add(newInterval);
                newInterval = interval;
            } else if(interval[1] < newInterval[0]) {
                result.add(interval);
            } else {
            // its an overlap since possibility of new interval existing in left&right current interval is checked
            // update lowest of start & highest of end & not insert
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        result.add(newInterval);
        return result.toArray(new int[result.size()][]);

    }
}
