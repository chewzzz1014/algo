import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ClosestPair {
	
	public ClosestPair() {
		
	}
	double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }
	
	Point[] readPointsFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        ArrayList<Point> pointsList = new ArrayList<>();
        String line;

        while ((line = reader.readLine()) != null) {
            String[] coordinates = line.split(" ");
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);
            pointsList.add(new Point(x, y));
        }

        reader.close();
        return pointsList.toArray(new Point[0]);
    }
	
}
