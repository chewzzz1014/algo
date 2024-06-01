package topInterview150;

import java.util.*;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) { // if it's first character of target
                    if(dfs(board, i, j, 0, word, new HashSet<>())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int index, String word, HashSet<String> visited) {
        if(index == word.length()) return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length
            || visited.contains(i + "," + j)
            || board[i][j] != word.charAt(index)) return false;

        visited.add(i + "," + j);

        if(dfs(board, i+1, j, index+1, word, visited)
            || dfs(board, i-1, j, index+1, word, visited)
            || dfs(board, i, j+1, index+1, word, visited)
            || dfs(board, i, j-1, index+1, word, visited)) {
            return true;
        }

        visited.remove(i + "," + j);
        return false;
    }   
}
