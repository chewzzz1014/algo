package leetcode75;

public class NumberProvinces {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        int[] visited = new int[n];

        for(int i=0; i<n; i++) {
            if(visited[i] == 0) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, int[] visited, int i) {
        for(int j=0; j<isConnected.length; j++) {
            if(isConnected[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(isConnected, visited, j);
            }
        }
    }
}
