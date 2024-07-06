package topInterview150;

public class ModifyMatrix {
     public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] cols = new int[n];
        for(int j=0; j<n; j++) {
            for(int i=0; i<m; i++) {
                cols[j] = Math.max(cols[j], matrix[i][j]);
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == -1) {
                    matrix[i][j] = cols[j];
                }
            }
        }
        return matrix;
    }
}
