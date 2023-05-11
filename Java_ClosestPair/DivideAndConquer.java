import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class DivideAndConquer extends ClosestPair {	
	static Point[] closestStripPair;    
	
	 // Divide-and-conquer approach
    public Point[] closestPair(Point[] points) {
        // Sort points based on x-coordinate
        Arrays.sort(points, Comparator.comparingInt(p -> p.x));
        int mid = points.length / 2;
        for(Point p: points)
        	System.out.println(p.toString());
        Point midPoint = points[mid];
        System.out.println("*** "+midPoint.toString());

        // Divide the points into two halves
        Point[] leftPoints = Arrays.copyOfRange(points, 0, mid);
        Point[] rightPoints = Arrays.copyOfRange(points, mid, points.length);

        // Recursively find the closest pair in each half
        Point[] closestPairLeft = closestPair(leftPoints);
        Point[] closestPairRight = closestPair(rightPoints);

        // Determine the closer pair from the two halves
        double leftDist = distance(closestPairLeft[0], closestPairLeft[1]);
        double rightDist = distance(closestPairRight[0], closestPairRight[1]);
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
            for (int j = i + 1; j < len && (strip[j].y - strip[i].y) < min; j++) {
                double dist = distance(strip[i], strip[j]);
                if (dist < min) {
                    min = dist;
                }
            }
        }

        return min;
    }
}
