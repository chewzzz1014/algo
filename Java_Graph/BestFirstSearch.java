import java.util.*;

public class BestFirstSearch {
    
    private static final int N = 5; // number of nodes
    private static final int MAX_WEIGHT = 10; // maximum edge weight
    private static final int START_NODE = 0; // starting node
    private static final int GOAL_NODE = 4; // goal node
    
    private static int[][] adjacencyMatrix = new int[N][N]; // adjacency matrix
    private static int[] fValues = new int[N]; // f-values for each node
    private static boolean[] visited = new boolean[N]; // visited nodes
    
    public static void main(String[] args) {
        // generate random connected graph
        generateRandomGraph();
        
        // calculate f-values for each node
        calculateFValues();
        
        // find shortest path using best-first search
        List<Integer> path = bestFirstSearch();
        
        System.out.println("Adjacency matrix:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("Shortest path from node " + START_NODE + " to node " + GOAL_NODE + ": " + path);
    }
    
    private static void generateRandomGraph() {
        Random random = new Random();
        
        // generate random connected graph
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (random.nextInt(2) == 0) {
                    adjacencyMatrix[i][j] = random.nextInt(MAX_WEIGHT) + 1;
                    adjacencyMatrix[j][i] = adjacencyMatrix[i][j];
                }
            }
        }
        
        // ensure graph is connected
        for (int i = 0; i < N; i++) {
            if (!isConnected(i)) {
                int j = random.nextInt(N - 1);
                if (j >= i) j++;
                adjacencyMatrix[i][j] = random.nextInt(MAX_WEIGHT) + 1;
                adjacencyMatrix[j][i] = adjacencyMatrix[i][j];
            }
        }
        
     // assign f-values to the nodes based on the adjacency matrix
        for (int i = 0; i < N; i++) {
            int gValue = adjacencyMatrix[START_NODE][i];
            int hValue = Math.abs(i - GOAL_NODE);
            fValues[i] = gValue + hValue;
        }
    }
    
    private static void calculateFValues() {
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            int gValue = random.nextInt(MAX_WEIGHT) + 1;
            int hValue = Math.abs(i - GOAL_NODE);
            fValues[i] = gValue + hValue;
        }
    }
    
    private static List<Integer> bestFirstSearch() {
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> fValues[n1] - fValues[n2]);
        queue.add(START_NODE);
        visited[START_NODE] = true;
        
        Map<Integer, Integer> parentMap = new HashMap<>();
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == GOAL_NODE) break;
            
            for (int i = 0; i < N; i++) {
                if (adjacencyMatrix[current][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    parentMap.put(i, current);
                }
            }
        }
        
        List<Integer> path = new ArrayList<>();
        int current = GOAL_NODE;
        while (current != START_NODE) {
            path.add(current);
            current = parentMap.get(current);
        }
        path.add(START_NODE);
        Collections.reverse(path);
        
        return path;
    }
    
    // use depth-first search to check if the node is connected to any other node
    private static boolean isConnected(int node) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        boolean[] visited = new boolean[N];
        
        stack.push(node);
        visited[node] = true;
        
        while (!stack.isEmpty()) {
            int current = stack.pop();
            
            for (int i = 0; i < N; i++) {
                if (adjacencyMatrix[current][i] != 0 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
        
        // check if all nodes are visited
        for (boolean v : visited) {
            if (!v) return false;
        }
        
        return true;
    }
    
}
