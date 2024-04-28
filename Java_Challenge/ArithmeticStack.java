import java.util.*;

import List.ArrayList;

import java.lang.*;
public class ArithmeticStack {
    public int solution(String S) {
        // Implement your solution here
        String[] inputs = S.split(" ");
        ArrayList<String> stack = new ArrayList<>();
        int n1, n2;
       
        for(int i=0; i<inputs.length; i++){
            try{
            switch(inputs[i]){
                    case "POP":
                    stack.remove(stack.size()-1);
                    break;
                case "DUP":
                    stack.add(stack.get(stack.size()-1));
                    break;
                case "+":
                    n1 = Integer.parseInt(stack.get(stack.size()-1));
                    stack.remove(stack.size()-1);

                    n2 = Integer.parseInt(stack.get(stack.size()-1));
                    stack.remove(stack.size()-1);
                    
                    stack.add((n1+n2)+"");
                    break;
                case "-":
                    n1 = Integer.parseInt(stack.get(stack.size()-1));
                    stack.remove(stack.size()-1);

                    n2 = Integer.parseInt(stack.get(stack.size()-1));
                    stack.remove(stack.size()-1);

                    stack.add((n1-n2)+"");
                    break;
                default:
                    stack.add(inputs[i]);
                    break;
               }
            }catch(Exception e){
                   return -1;
               }
            }
            //System.out.println(inputs[i]);

        return Integer.parseInt(stack.get(stack.size()-1));
    }
}
