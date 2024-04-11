package topInterview150;

public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        // when 0 is found, marked 0 at first ele of its row and col
        // starting from index 1 while changing values and in the last we are changing first row/col values.

        boolean fr = false, fc = false;

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i==0) fr = true;
                    if(j==0) fc = true;
                    // mark its row and col
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // convert non-first row and col
        for(int i=1; i<matrix.length; i++) {
            for(int j=1; j<matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(fr) { // if first row is marked
            for(int j=0; j<matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if(fc) {
            for(int i=0; i<matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
