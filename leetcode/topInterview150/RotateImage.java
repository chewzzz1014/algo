package topInterview150;

public class RotateImage {
    public void rotate(int[][] matrix) {
        /*
        * clockwise rotate
        * first reverse up to down, then swap the symmetry 
        * 1 2 3     7 8 9     7 4 1
        * 4 5 6  => 4 5 6  => 8 5 2
        * 7 8 9     1 2 3     9 6 3
        */

        int m = matrix.length;
        int n = matrix[0].length;

        // reverse up and down
        for(int start=0, end=m-1; start<end; start++, end--) {
            for(int j=0; j<n; j++) {
                int temp = matrix[start][j];
                matrix[start][j] = matrix[end][j];
                matrix[end][j] = temp;
            }
        }

        // swap symmetry
        for(int i=0; i<m; i++) {
            for(int j=i+1; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }
}
