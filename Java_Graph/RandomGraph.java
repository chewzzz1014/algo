import java.util.*;

public class RandomGraph {
	boolean[][] adjacencyMatrix;
    int numVertices;
    
    public RandomGraph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new boolean[numVertices][numVertices];
    }
    
    public void addEdge(int i, int j) {
        adjacencyMatrix[i][j] = true;
        adjacencyMatrix[j][i] = true;
    }
    
    public void removeEdge(int i, int j) {
        adjacencyMatrix[i][j] = false;
        adjacencyMatrix[j][i] = false;
    }
    
    public boolean isEdge(int i, int j) {
        return adjacencyMatrix[i][j];
    }
    
    public static RandomGraph generateGraph(int numVertices) {
        RandomGraph graph = new RandomGraph(numVertices);
        Random random = new Random();
        boolean[] visited = new boolean[numVertices];
        int start = random.nextInt(numVertices);
        visited[start] = true;
        int count = 1;
        while (count < numVertices) {
            int end = random.nextInt(numVertices);
            if (!visited[end]) {
                graph.addEdge(start, end);
                visited[end] = true;
                start = end;
                count++;
            }
        }
        return graph;
    }
}
