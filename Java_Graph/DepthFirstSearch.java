import java.util.*;

import List.ArrayList;
import List.List;

public class DepthFirstSearch {
	 public static List<Integer> dfs(RandomGraph rg, int start, int end) {
	        boolean[] visited = new boolean[rg.numVertices];
	        List<Integer> path = new ArrayList<Integer>();
	        dfsHelper(rg, start, end, visited, path);
	        return path;
	    }
	    
	   private static void dfsHelper(RandomGraph rg, int curr, int end, boolean[] visited, List<Integer> path) {
	        visited[curr] = true;
	        path.add(curr);
	        if (curr == end) {
	            return;
	        }
	        for (int i = 0; i < rg.numVertices; i++) {
	            if (rg.isEdge(curr, i) && !visited[i]) {
	                dfsHelper(rg, i, end, visited, path);
	                if (path.get(path.size() - 1) == end) {
	                    return;
	                }
	            }
	        }
	        path.remove(path.size() - 1);
	    }
	
	   public static void main(String [] args) {
		 int numVertices = 10;
	        RandomGraph graph = RandomGraph.generateGraph(numVertices);
	        System.out.println("Adjacency matrix:");
	        for (int i = 0; i < numVertices; i++) {
	            for (int j = 0; j < numVertices; j++) {
	                System.out.print(graph.isEdge(i, j) ? "T " : "F ");
	            }
	            System.out.println();
	        }
	        int start = 0;
	        int end = numVertices - 1;
	        List<Integer> path = dfs(graph, start, end);
	        System.out.println("DFS path from " + start + " to " + end + ": " + path);
	}
}
