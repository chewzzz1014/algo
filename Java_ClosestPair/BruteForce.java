
public class BruteForce extends ClosestPair {
	public BruteForce() {
		
	}
	
	 public Point[] bruteForce(Point[] points) {
	        int n = points.length;
	        double minDistance = Double.POSITIVE_INFINITY;
	        Point[] closestPair = new Point[2];
	        
	        for (int i = 0; i < n; ++i) {
	         for (int j = i + 1; j < n; ++j) {
	              double dist = distance(points[i], points[j]);
	             if (dist < minDistance) {
	                minDistance = dist;
	                closestPair[0] = points[i];
	                closestPair[1] = points[j];
	            }
	         }
	      }
	    return closestPair;
	}
}
