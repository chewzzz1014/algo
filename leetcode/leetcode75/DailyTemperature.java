package leetcode75;

import java.util.*;

public class DailyTemperature {
    
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=n-1; i>=0; i--) {
            // pop till find next greater element to the right
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i])
                stack.pop();

            if(!stack.isEmpty())
                answer[i] = stack.peek() - i;
            
            stack.push(i);
        }

        return answer;
    }
}
