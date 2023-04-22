import java.util.*;

public class RandomGraph {
	boolean[][] adjMatrix;
	int numVertices;
	Random rand;
	
	public RandomGraph(int numVertices) {
		this.numVertices = numVertices;
		adjMatrix = new boolean[numVertices][numVertices];
		rand = new Random();
		generateGraph();
	}
	
	public void generateGraph() {
		for (int i=0; i<numVertices; i++) {
			for (int j=0; j<numVertices; j++) {
				if (rand.nextBoolean()) {
					addEdge(i, i);
				}
			}
		}
	}
	
	public void addEdge(int i, int j) {
		adjMatrix[i][j] = true;
		adjMatrix[j][i] = true;
	}
	
	public List<Integer> getPath(int start, int end, int[] parent) {
		List<Integer> path = new ArrayList<>();
		int current = end;
		while (current != -1) {
			path.add(0, current);
			current = parent[current];
		}
		if (path.get(0) != start) {
			return null;
		}
		return path;
	}
	
	public void printGraph() {
		for(int i=0; i<numVertices; i++) {
			for (int j=0; j<numVertices; j++) {
				System.out.print(adjMatrix[j][i]? "1": "0 ");
			}
			System.out.println();
		}
	}
}
