// Chew Zi Qing 212360
import java.io.IOException;
import java.util.Scanner;

// main program that runs both approaches of closest pair algo
public class MainClosestPair {
	public static void main (String[] args) {
		final String FILE_NAME = "C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_ClosestPair\\points.txt";
		DivideAndConquer dc = new DivideAndConquer();
		BruteForce bf = new BruteForce();
		
		// get N from user
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of points, N (suggested value: 10, 100, 1000): ");
		int size = sc.nextInt();
		System.out.println();
		sc.close();
		
		try {
			// generate N random points. Read these points
            (new Point()).writeRandmNPoints(FILE_NAME, size);
            Point[] pointsArray = dc.readPointsFromFile(FILE_NAME);

            // brute force and DNC for closest pair algo
            Point[] bruteForceClosestPair = bf.bruteForce(pointsArray);
            Point[] divideConquerClosestPair = dc.closestPair(pointsArray);

            // output the closest pair coordinates and distances for brute force
            System.out.println("Closest pair (Brute Force): " + 
            					bruteForceClosestPair[0].toString() + ", " +
            					bruteForceClosestPair[1].toString());
            System.out.println("Distance: " + bf.distance(bruteForceClosestPair[0], bruteForceClosestPair[1]));

         // output the closest pair coordinates and distances for DNC
         // check if the pair is null
            if (divideConquerClosestPair == null 
            	|| divideConquerClosestPair[0] == null 
            	|| divideConquerClosestPair[1] == null) {
                System.out.println("Error: No closest pair found by divide and conquer algorithm.");
            } else {
                System.out.println("Closest pair (divide and conquer): " + 
                					divideConquerClosestPair[0].toString() + ", " +
                					divideConquerClosestPair[1].toString());
                		
                System.out.println("Distance: " + 
                					dc.distance(divideConquerClosestPair[0], 
                					divideConquerClosestPair[1]));
            }

        } catch (IOException e) {
            System.out.println("Error reading points from the file.");
            e.printStackTrace();
        }
	}
}
