import java.util.*;

import List.ArrayList;
import List.List;

public class BreadthFirstSearch {
	 public static List<Integer> bfs(RandomGraph rg, int start, int end) {
	        boolean[] visited = new boolean[rg.numVertices];
	        int[] parent = new int[rg.numVertices];
	        List<Integer> queue = new ArrayList<Integer>();
	        queue.add(start);
	        visited[start] = true;
	        while (!queue.isEmpty()) {
	            int curr = queue.remove(queue.size()-1);
	            if (curr == end) {
	                break;
	            }
	            for (int i = 0; i < rg.numVertices; i++) {
	                if (rg.isEdge(curr, i) && !visited[i]) {
	                    visited[i] = true;
	                    parent[i] = curr;
	                    queue.add(i);
	                }
	            }
	        }
	        List<Integer> path = new ArrayList<Integer>();
	        for (int curr = end; curr != start; curr = parent[curr]) {
	            path.add(curr);
	        }
	        path.add(start);
	        Collections.reverse(path);
	        return path;
	  }

	 public static void main (String[]args) {
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
	        
	        List<Integer> path2 = bfs(graph, start, end);
	        System.out.println("BFS path from " + start + " to " + end + ": " + path2);
	 }
}
