package topInterview150;

import java.util.Arrays;

public class ArrowsBurstBallon {
    public int findMinArrowShots(int[][] points) {
        // sort by Xend
        // check for overlap: if not overlap need one arrow. else no need arrow

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        // start with needing one arrow for first ballon
        int arrows = 1;
        int prev = 0;

        for(int current = 1; current < points.length; current++) {
            if(points[current][0] > points[prev][1]) {
                arrows++;
                prev = current;
            }
        }

        return arrows;
    }
}
