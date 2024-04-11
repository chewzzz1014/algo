package topInterview150;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        // left to right: + rowBegin
        // up to down: - colEnd
        // right to left: - rowEnd
        // down to up: + colBegin

        List<Integer> result = new LinkedList<Integer>();
        if(matrix == null || matrix.length == 0) return result;

        int startRow = 0, endRow = matrix.length-1;
        int startCol = 0, endCol = matrix[0].length-1;
        int dir = 0;

        while (startRow <= endRow && startCol <= endCol) {
            switch(dir) {
                case 0: // right
                    for(int col=startCol; col<=endCol; col++)
                        result.add(matrix[startRow][col]);
                    startRow++;
                    break;
                case 1: //down
                    for(int row=startRow; row<=endRow; row++)
                        result.add(matrix[row][endCol]);
                    endCol--;
                    break;
                case 2: // left
                    for(int col=endCol; col>=startCol; col--) 
                        result.add(matrix[endRow][col]);
                    endRow--;
                    break;
                case 3: // up
                    for(int row=endRow; row>=startRow; row--)
                        result.add(matrix[row][startCol]);
                    startCol++;
                    break;
            }
            dir = (dir+1) % 4;
        }
        return result;
    }
}
