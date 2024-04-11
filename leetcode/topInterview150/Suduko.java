package topInterview150;

import java.util.HashSet;
import java.util.Set;

public class Suduko {
    public boolean isValidSudoku(char[][] board) {
        /*
        Example of representation
        - '4' in row 7 is encoded as "7(4)".
        - '4' in column 7 is encoded as "(4)7".
        - '4' in the top-right block is encoded as "0(4)2"
        */

        Set<String> seen = new HashSet<>();
        for (int i=0; i<9; i++) {
            for (int  j=0; j<9; j++) {
                // if the board is already filled
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (!seen.add(i + b) ||
                        !seen.add(b + j) || 
                        !seen.add(i/3 + b + j/3))
                        return false;
                }
            }
        }
        return true;
    }
}
