package leetcode75;

import java.util.*;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[n];

        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]) {
                int popIndex = stack.pop();
                result[popIndex] = i - popIndex;
            }
            stack.push(i);
        }

        return result;
    }
}
