package topInterview150;

public class Search2DMatrix {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        if(matrix[0] == null || matrix[0].length == 0) return false;

        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row * col - 1;

        while(start + 1 < end) {
            int mid = (end - start) / 2 + start;
            int value = matrix[mid/col][mid%col];
            if(value == target) {
                return true;
            } else if(value < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if(matrix[start/col][start%col] == target) {
            return true;
        } else if(matrix[end/col][end%col] == target) {
            return true;
        } else {
            return false;
        }
    }
}
