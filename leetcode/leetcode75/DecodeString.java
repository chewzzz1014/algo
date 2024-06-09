package leetcode75;

import java.util.*;

public class DecodeString {
    
    public String decodeString(String s) {
        // alpha or [ : push to dict stack
        // digits : collect all numbers and push total to nums stack
        // ] : get all alpha till meet [. get numbers and repeat the seq for this number of times
        if(s == null || s.length() == 0) return "";

        Stack<String> dict = new Stack<>();
        Stack<Integer> nums = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(Character.isDigit(c)) {
                int num = c - '0';
                while(Character.isDigit(s.charAt(i+1))) {
                    num = num * 10 + (s.charAt(i+1) - '0');
                    i++;
                }
                nums.push(num);
            } else if(Character.isLetter(c)) {
                dict.push(c + "");
            } else if(c == '[') {
                dict.push("[");
            } else if(c == ']') {
                String temp = "";
                while(dict.peek() != "[") {
                    temp = dict.pop() + temp;
                }
                dict.pop(); // pop [

                int repeat = nums.pop();
                String local = "";
                for(int j=0; j<repeat; j++) {
                    local += temp;
                }

                dict.push(local);
            }
        }

        String res = "";
        while(!dict.isEmpty()) {
            res = dict.pop() + res;
        }

        return res;
    }
}
