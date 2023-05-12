// Chew Zi Qing 212360

// brute force closest pair
public class BruteForce extends ClosestPair {
	public BruteForce() {
		
	}
	
	// implement the algo
	public Point[] bruteForce(Point[] points) {
	      int n = points.length;
	      double minDistance = Double.POSITIVE_INFINITY;
	      Point[] closestPair = new Point[2];
	        
	      // nested looping for every point
	      for (int i = 0; i < n; i++) {
	    	  for (int j = i + 1; j < n; ++j) {
	    		 
	    		 // skip if 2 points are same
	        	 if (points[i].equals(points[j])) {
	                  continue; 
	             }
	        	 
	        	 // calculate the distance and compare with min distance
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
