import java.io.IOException;

public class MainClosestPair {
	public static void main (String[] args) {
		DivideAndConquer dc = new DivideAndConquer();
		BruteForce bf = new BruteForce();
		
		try {
            // Read points from the text file
            Point[] pointsArray = dc.readPointsFromFile("C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_ClosestPair\\points.txt");

            // Perform the closest pair calculations using both approaches
            Point[] bruteForceClosestPair = bf.bruteForce(pointsArray);
            Point[] divideConquerClosestPair = dc.closestPair(pointsArray);

            // Output the closest pair coordinates and distances
            System.out.println("Closest Pair (Brute Force):");
            System.out.println("(" + bruteForceClosestPair[0].x + ", " + bruteForceClosestPair[0].y + ")");
            System.out.println("(" + bruteForceClosestPair[1].x + ", " + bruteForceClosestPair[1].y + ")");
            System.out.println("Distance: " + bf.distance(bruteForceClosestPair[0], bruteForceClosestPair[1]));

            System.out.println("\nClosest Pair (Divide and Conquer):");
            System.out.println("(" + divideConquerClosestPair[0].x + ", " + divideConquerClosestPair[0].y + ")");
            System.out.println("(" + divideConquerClosestPair[1].x + ", " + divideConquerClosestPair[1].y + ")");
            System.out.println("Distance: " + dc.distance(divideConquerClosestPair[0], divideConquerClosestPair[1]));

        } catch (IOException e) {
            System.out.println("Error reading points from the file.");
            e.printStackTrace();
        }
	}
}
