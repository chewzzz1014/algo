package progSkills;

public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int total = 0;
        int n = mat.length;

        for(int i=0; i<n; i++) {
            // primary diagonal
            total += mat[i][i];
            // secondary diagonal (from bottom left to top right)
            total += mat[n-1-i][i];
        }
        
        // remove duplicate (if n is odd)
        return n % 2 == 0 ? total : total - mat[n/2][n/2];
    }
}
