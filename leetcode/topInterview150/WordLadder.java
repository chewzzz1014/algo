package topInterview150;

import java.util.*;

public class WordLadder {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> validWords = new HashSet<>(wordList);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int steps = 1;
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for(int count=0; count<queueSize; count++) {
                String curr = queue.poll();
                for(int i=0; i<endWord.length(); i++) {
                   char[] arr = curr.toCharArray();
                   for(char x = 'a'; x<='z'; x++) {
                        arr[i] = x;
                        String temp = new String(arr);
                        if(validWords.contains(temp)) {
                            if(temp.equals(endWord)) return steps+1;
                            queue.offer(temp);
                            validWords.remove(temp);
                        }
                   }
                }
            }
            steps++;
        }
        return 0;
    }
}
