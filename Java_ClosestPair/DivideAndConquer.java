import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class DivideAndConquer extends ClosestPair {	
	static Point[] closestStripPair = new Point[2];    
	
	 // Divide-and-conquer approach
    public Point[] closestPair(Point[] points) {
    	BruteForce bf = new BruteForce();
    	
    	 if (points.length <= 1) {
    	        return new Point[2]; // Return an empty array if no or only one point is given
    	 } else if (points.length <= 3) {
    	        return bf.bruteForce(points);
    	 }
    	 
        // Sort points based on x-coordinate
        Arrays.sort(points, Comparator.comparingInt(p -> p.x));
        
        int mid = points.length / 2;
        Point midPoint = points[mid];

        // Divide the points into two halves
        Point[] leftPoints = Arrays.copyOfRange(points, 0, mid);
        Point[] rightPoints = Arrays.copyOfRange(points, mid, points.length);

        // Recursively find the closest pair in each half
        Point[] closestPairLeft = closestPair(leftPoints);
        Point[] closestPairRight = closestPair(rightPoints);

        // Determine the closer pair from the two halves
        
        //double leftDist = distance(closestPairLeft[0], closestPairLeft[1]);
        double leftDist = Double.MAX_VALUE;
        if (closestPairLeft != null && closestPairLeft[0] != null && closestPairLeft[1] != null) {
            leftDist = distance(closestPairLeft[0], closestPairLeft[1]);
        }
        double rightDist = Double.MAX_VALUE;
        if (closestPairRight != null && closestPairRight[0] != null && closestPairRight[1] != null) {
            rightDist = distance(closestPairRight[0], closestPairRight[1]);
        }
        
        double minDist = Math.min(leftDist, rightDist);
        Point[] closestPair = (minDist == leftDist) ? closestPairLeft : closestPairRight;

        // Find the closest pair across the two halves
        ArrayList<Point> strip = new ArrayList<>();
        for (Point point : points) {
            if (Math.abs(point.x - midPoint.x) < minDist) {
                strip.add(point);
            }
        }

        double stripDist = closestStrip(strip.toArray(new Point[0]), minDist);

        if (stripDist < minDist) {
        	minDist = stripDist;
            closestPair = closestStripPair;
        }

        return closestPair;
    }

    double closestStrip(Point[] strip, double minDist) {
    	double min = minDist;
        int len = strip.length;
      
        // Sort the strip points by y-coordinate
        Arrays.sort(strip, Comparator.comparingInt(p -> p.y));

        // Iterate over each point in the strip
        for (int i = 0; i < len; i++) {
            // Compare each point with the next 7 points in the strip
            //for (int j = i + 1; j < len && (strip[j].y - strip[i].y) < min; j++) {
        	for (int j = i + 1; j < Math.min(i + 8, len); j++) {
                double dist = distance(strip[i], strip[j]);
                if (dist == 0) {
                	continue;
                }
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
