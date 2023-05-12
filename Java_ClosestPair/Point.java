import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

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
	 
	 public boolean equals(Point point2) {
		 return x == point2.x && y == point2.y;
	 }
	 
	 public void writeRandmNPoints(String file, int n) throws IOException {
		 BufferedWriter writer = new BufferedWriter(new FileWriter(file));

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
