package leetcode75;

import java.util.*;

public class KeyAndRoom {
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // DFS
        Stack<Integer> stack = new Stack<>();
        Set<Integer> seen = new HashSet<>();

        stack.push(0);
        seen.add(0);

        while(!stack.isEmpty()) {
            int curr = stack.pop();
            for(int key : rooms.get(curr)) {
                if(!seen.contains(key)) {
                    seen.add(key);
                    stack.push(key);

                    if(seen.size() == rooms.size()) return true;
                }
            }
        }

        return seen.size() == rooms.size();
    }
}
