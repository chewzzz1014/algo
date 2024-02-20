// Chew Zi Qing 212360
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

// define 2D point with x and y coordinate
public class Point {
	 int x, y;

	 public Point() {
		 
	 }
	 
	 public Point(int x, int y) {
	     this.x = x;
	     this.y = y;
	 }
	 
	 public String toString() {
		 return "(" + this.x + ", " + this.y + ")";
	 }
	 
	 // to compare whether 2 points are same
	 // to avoid algo checking on distance on the same point
	 public boolean equals(Point point2) {
		 return x == point2.x && y == point2.y;
	 }
	 
	 // generate N random points in points.txt
	 public void writeRandmNPoints(String file, int n) throws IOException {
		 BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		 
		 // x and y coordinate in range [0, 99]
	     Random random = new Random();

	     for (int i = 0; i < n; i++) {
	        int x = random.nextInt(100); 
	        int y = random.nextInt(100); 
	        writer.write(x + " " + y);
	        writer.newLine();
	     }

	     writer.close();
	     System.out.println("Generated " + n + " points in 'points.txt'...\n");
	 }
}
