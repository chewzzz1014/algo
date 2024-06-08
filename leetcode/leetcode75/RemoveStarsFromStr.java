package leetcode75;

import java.util.*;

public class RemoveStarsFromStr {
    
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(c == '*' && !stack.empty()) stack.pop();
            else stack.push(c);
        }

        for(char c : stack) sb.append(c);

        return sb.toString();
    }
}
