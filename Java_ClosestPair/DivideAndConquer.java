// Chew Zi Qing 212360
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// divide and conquer closest pair
public class DivideAndConquer extends ClosestPair {	
	// initialize cloestPair array of size 2
	static Point[] closestStripPair = new Point[2];    
	
	// actual implementation of algo
    public Point[] closestPair(Point[] points) {
    	BruteForce bf = new BruteForce();
    	
    	// return empty array if 0/1 point is given
    	// use brute force if <=3 points
    	 if (points.length <= 1) {
    	       return new Point[2];
    	 } else if (points.length <= 3) {
    	       return bf.bruteForce(points);
    	 }
    	 
        // sort points based on x coordinate
        Arrays.sort(points, Comparator.comparingInt(p -> p.x));
        
        // find the mid point
        int mid = points.length / 2;
        Point midPoint = points[mid];

        // divide the points into left and right (mid point in middle)
        Point[] leftPoints = Arrays.copyOfRange(points, 0, mid);
        Point[] rightPoints = Arrays.copyOfRange(points, mid, points.length);

        // recursively find the closest pair in each half
        Point[] closestPairLeft = closestPair(leftPoints);
        Point[] closestPairRight = closestPair(rightPoints);

        // find the distance of closest pair from each half
        // determine the closer pair from the two halves
        double leftDist = Double.MAX_VALUE;
        if (closestPairLeft != null && closestPairLeft[0] != null && closestPairLeft[1] != null) {
            leftDist = distance(closestPairLeft[0], closestPairLeft[1]);
        }
        double rightDist = Double.MAX_VALUE;
        if (closestPairRight != null && closestPairRight[0] != null && closestPairRight[1] != null) {
            rightDist = distance(closestPairRight[0], closestPairRight[1]);
        }
        
        // determine the min distance & pair with min distance
        double minDist = Math.min(leftDist, rightDist);
        Point[] closestPair = (minDist == leftDist) ? closestPairLeft : closestPairRight;

        // find the closest pair across the two halves
        ArrayList<Point> strip = new ArrayList<>();
        for (Point point : points) {
            if (Math.abs(point.x - midPoint.x) < minDist) {
                strip.add(point);
            }
        }

        // find closest pair in strip
        double stripDist = closestStrip(strip.toArray(new Point[0]), minDist);

        // compare min distance of strip to min distance
        if (stripDist < minDist) {
        	minDist = stripDist;
            closestPair = closestStripPair;
        }
        return closestPair;
    }

    double closestStrip(Point[] strip, double minDist) {
    	double min = minDist;
        int len = strip.length;
      
        // sort the strip points by y coordinate
        Arrays.sort(strip, Comparator.comparingInt(p -> p.y));

        // loop everything point in the strip
        for (int i = 0; i < len; i++) {
            // compare each point with the next 7 points in the strip
        	for (int j = i + 1; j < Math.min(i + 8, len); j++) {
        		// if they're same points
        		if (strip[i].equals(strip[j])) {
        			continue; 
        		}
        		
                double dist = distance(strip[i], strip[j]);
                if (dist < min) {
                    min = dist;
                    closestStripPair[0] = strip[i];
                    closestStripPair[1] = strip[j];
                }
            }
        }

        return min;
    }
}
