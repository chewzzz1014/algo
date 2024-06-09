package leetcode75;

import java.util.*;

public class Dota2Senate {
    
    public String predictPartyVictory(String senate) {
        Queue<Integer> rad = new LinkedList<>();
        Queue<Integer> dir = new LinkedList<>();
        int n = senate.length();

        for(int i=0; i<n; i++) {
            if(senate.charAt(i) == 'R') {
                rad.add(i);
            } else {
                dir.add(i);
            }
        }

        // fight. during a round, the party that comes first will win
        // winner goes to the end of queue
        while(!rad.isEmpty() && !dir.isEmpty()) {
            if(rad.peek() < dir.peek()) {
                rad.add(n++);
            } else {
                dir.add(n++);
            }
            rad.poll();
            dir.poll();
        }

        // which party is empty first will lose
        return (rad.isEmpty() ? "Dire" : "Radiant");
    }
}
