import java.util.*;

public class AStarSearch {
    
    private static final int N = 5; // number of nodes
    private static final int MAX_WEIGHT = 10; // maximum edge weight
    private static final int START_NODE = 0; // starting node
    private static final int GOAL_NODE = 4; // goal node
    
    private static int[][] adjacencyMatrix = new int[N][N]; // adjacency matrix
    private static int[] gValues = new int[N]; // g-values for each node
    private static int[] hValues = new int[N]; // h-values for each node
    private static int[] fValues = new int[N]; // f-values for each node
    private static boolean[] visited = new boolean[N]; // visited nodes
    
    public static void main(String[] args) {
        // generate random connected graph
        generateRandomGraph();
        
        // calculate g-values and h-values for each node
        calculateGValues();
        calculateHValues();
        
        // find shortest path using A algorithm
        List<Integer> path = aStarSearch();
        
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
    }
    
    private static void calculateGValues() {
    	 Arrays.fill(gValues, Integer.MAX_VALUE);
         gValues[START_NODE] = 0;
         
         PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> gValues[n1] - gValues[n2]);
         queue.add(START_NODE);
         
         while (!queue.isEmpty()) {
             int current = queue.poll();
             
             for (int i = 0; i < N; i++) {
                 if (adjacencyMatrix[current][i] != 0) {
                     int newGValue = gValues[current] + adjacencyMatrix[current][i];
                     if (newGValue < gValues[i]) {
                         gValues[i] = newGValue;
                         queue.remove(i);
                         queue.add(i);
                     }
                 }
             }
         }
    }
    
    // calculate h-values for each node
    private static void calculateHValues() {
        for (int i = 0; i < N; i++) {
            hValues[i] = Math.abs(i - GOAL_NODE);
        }
    }

    private static List<Integer> aStarSearch() {
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> fValues[n1] - fValues[n2]);
        queue.add(START_NODE);
        visited[START_NODE] = true;
        
        Map<Integer, Integer> parentMap = new HashMap<>();
        Map<Integer, Integer> gValues = new HashMap<>();
        gValues.put(START_NODE, 0);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == GOAL_NODE) break;
            
            for (int i = 0; i < N; i++) {
                if (adjacencyMatrix[current][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    int newGValue = gValues.get(current) + adjacencyMatrix[current][i];
                    if (!gValues.containsKey(i) || newGValue < gValues.get(i)) {
                        gValues.put(i, newGValue);
                        int fValue = newGValue + Math.abs(i - GOAL_NODE);
                        fValues[i] = fValue;
                        queue.add(i);
                        parentMap.put(i, current);
                    }
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

    private static boolean isConnected(int node) {
        boolean[] visited = new boolean[N];
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        stack.push(node);
        visited[node] = true;

        while (!stack.empty()) {
            int current = stack.pop();
            for (int i = 0; i < N; i++) {
                if (adjacencyMatrix[current][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }

        for (boolean nodeVisited : visited) {
            if (!nodeVisited) {
                return false;
            }
        }
        return true;
    }

}