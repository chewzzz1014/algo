package topInterview150;

import java.util.*;

public class MaxPointsOnLine {
    
     public int maxPoints(int[][] points) {
        if(points.length < 2) return points.length;

        int n = points.length;
        Set<String> visited = new HashSet<>();
        int maxPoints = 1;
       
        for(int i=0; 
                i<n && !visited.contains(points[i][0] + "," + points[i][1]); 
                i++) {
            int localMax=1, overlap = 0;
            Map<Double, Integer> gradients = new HashMap<>();

            for(int j = i+1; j<n; j++) {
                if(points[i][0] == points[j][0] && points[i][1] == points[j][1]) // include duplicated points
                    overlap++;
                else {
                    double gradient = getGradient(points[i], points[j]);
                    gradients.put(gradient, gradients.getOrDefault(gradient, 1) + 1);
                    localMax = Math.max(localMax, gradients.get(gradient));
                }
            }
            visited.add(points[i][0] + "," + points[i][1]);

            maxPoints = Math.max(maxPoints, localMax + overlap);
        }
        return maxPoints;
    }

    public double getGradient(int[] a, int[] b) {
        if(a[0] == b[0]) return Double.MAX_VALUE;
        if(a[1] == b[1]) return 0; // vertically parallel, no gradient
        return (double)(a[0]-b[0]) / (double)(a[1] - b[1]);
    }
}
