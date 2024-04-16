package topInterview150;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        /*

        digit: it should be one digit from the current number
        '+': number is over, we can add the previous number and start a new number
        '-': same as above
        '(': push the previous result and the sign into the stack, set result to 0, just calculate the new result within the parenthesis.
        ')': pop out the top two numbers from stack, first one is the sign before this pair of parenthesis, second is the temporary result before this pair of parenthesis. We add them together.
        */

        int n = s.length(), sign = 1, result = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0; i<n; i++) {
            if(Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while(i+1 < n && Character.isDigit(s.charAt(i+1))) {
                    sum = sum * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                result += sum * sign;
            } else if(s.charAt(i) == '+') {
                sign = 1;
            } else if(s.charAt(i) == '-') {
                sign = -1;
            } else if(s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if(s.charAt(i) == ')') {
                result = result * stack.pop() + stack.pop();
            }
        }

        return result;
    }
}
