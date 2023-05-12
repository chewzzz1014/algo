import java.io.IOException;
import java.util.Scanner;

public class MainClosestPair {
	public static void main (String[] args) {
		DivideAndConquer dc = new DivideAndConquer();
		BruteForce bf = new BruteForce();
		final String FILE_NAME = "C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_ClosestPair\\points.txt";
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of points, N (suggested value: 10, 100, 1000): ");
		int size = sc.nextInt();
		System.out.println();
		sc.close();
		
		try {
            (new Point()).writeRandmNPoints(FILE_NAME, size);
            Point[] pointsArray = dc.readPointsFromFile(FILE_NAME);

            // Perform the closest pair calculations using both approaches
            Point[] bruteForceClosestPair = bf.bruteForce(pointsArray);
            Point[] divideConquerClosestPair = dc.closestPair(pointsArray);

            // Output the closest pair coordinates and distances
            System.out.println("Closest pair (Brute Force): (" + 
			            		bruteForceClosestPair[0].x + ", " + 
			            		bruteForceClosestPair[0].y + "), (" + 
			            		bruteForceClosestPair[1].x + ", " + 
			            		bruteForceClosestPair[1].y + ")");
            System.out.println("Distance: " + bf.distance(bruteForceClosestPair[0], bruteForceClosestPair[1]));

            if (divideConquerClosestPair == null || divideConquerClosestPair[0] == null || divideConquerClosestPair[1] == null) {
                System.out.println("Error: No closest pair found by divide and conquer algorithm.");
            } else {
                System.out.println("Closest pair (divide and conquer): (" + 
                					divideConquerClosestPair[0].x + ", " + 
                					divideConquerClosestPair[0].y + "), (" + 
                					divideConquerClosestPair[1].x + ", " + 
                					divideConquerClosestPair[1].y + ")");
                System.out.println("Distance: " + 
                					dc.distance(divideConquerClosestPair[0], 
                					divideConquerClosestPair[1]));
            }
//            System.out.println("(" + divideConquerClosestPair[0].x + ", " + divideConquerClosestPair[0].y + ")");
//            System.out.println("(" + divideConquerClosestPair[1].x + ", " + divideConquerClosestPair[1].y + ")");
//            System.out.println("Distance: " + dc.distance(divideConquerClosestPair[0], divideConquerClosestPair[1]));

        } catch (IOException e) {
            System.out.println("Error reading points from the file.");
            e.printStackTrace();
        }
	}
}
