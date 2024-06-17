package topInterview150;

public class SurroundedRegions {
    
    public void solve(char[][] board) {
        // rule: if any of the cell in the region is on the edge, can't surround that region!

        int m = board.length - 1;
        int n = board[0].length - 1;

        // check on first and last col: label all cells connected to regions with cells on the edge with #
        for(int j=0; j<=n; j++) {
            if(board[0][j] == 'O') helper(board, 0, j);
            if(board[m][j] == 'O') helper(board, m, j); 
        }

        // check on first and last row: label all cells connected to regions with cells on the edge with #
        for(int i=0; i<=m; i++) {
            if(board[i][0] == 'O') helper(board, i, 0);
            if(board[i][n] == 'O') helper(board, i, n);
        }

        for(int i=0; i<=m; i++) {
            for(int j=0; j<=n; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == '#') { // it's in region which has cell on edge!
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void helper(char[][] board, int x, int y) {
        if(x<0 || x >= board.length || y<0 || y>=board[0].length) return;
        if(board[x][y] != 'O') return;

        board[x][y] = '#';
        helper(board, x-1, y);
        helper(board, x+1, y);
        helper(board, x, y-1);
        helper(board, x, y+1);
    }
}
