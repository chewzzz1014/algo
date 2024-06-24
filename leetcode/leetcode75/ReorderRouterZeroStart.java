package leetcode75;

import java.util.*;

public class ReorderRouterZeroStart {
    
    public int minReorder(int n, int[][] connections) {
        // DFS
        List<List<Integer>> adjList = new ArrayList<>();

        // setup adjency list
        for(int i=0; i<n; i++)
            adjList.add(new ArrayList<>());
        for(int[] pair : connections) {
            // assume i->j, mark as i as neg
            adjList.get(pair[0]).add(pair[1]);
            adjList.get(pair[1]).add(-pair[0]);
        }

        return dfs(adjList, new boolean[n], 0);
    }

    private int dfs(List<List<Integer>> adjList, boolean[] visited, int from) {
        int count = 0;
        visited[from] = true;

        // check the 'to' node
        for(var to : adjList.get(from)) {
            if(!visited[Math.abs(to)]) {
                count += dfs(adjList, visited, Math.abs(to)) + (to>0 ? 1 : 0);
            }
        }  
        return count;
    }
}
