package topInterview150;

import java.util.*;

public class WordSearch2 {
    private class TrieNode {
        TrieNode[] children;
        boolean isWord;
        String word;

        TrieNode() {
            children = new TrieNode[26];
            isWord = false;
            word = "";
        }
    }

    TrieNode root;
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        List<String> result = new ArrayList<>();

        for(String word : words) {
            insertWordIntoTrie(word);
        }

        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int index = board[i][j] - 'a';
                if(root.children[index] != null) {
                    TrieNode node = root;
                    dfs(board, i, j, result, node);
                }
            }
        }
        return result;
    }

    // insert a word into trie
    private void insertWordIntoTrie(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            int index = c - 'a';
            if(curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isWord = true;
        curr.word = word;
    }

    private void dfs(char[][] board, int i, int j, List<String> result, TrieNode node) {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return;
        char c = board[i][j];
        if(c == '#') return;
        if(node.children[c - 'a'] == null) return;

        if(node.children[c - 'a'].isWord) {
            result.add(node.children[c - 'a'].word);
            node.children[c - 'a'].isWord = false;
        }

        board[i][j] = '#'; // mark as visited

        dfs(board, i+1, j, result, node.children[c-'a']);
        dfs(board, i-1, j, result, node.children[c-'a']);
        dfs(board, i, j+1, result, node.children[c-'a']);
        dfs(board, i, j-1, result, node.children[c-'a']);

        board[i][j] = c; // mark it as unvisited for next round of dfs
    }
}
