package topInterview150;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] splitedPath = path.split("/");

        for(String p : splitedPath) {
            // a directory down
            if(!stack.isEmpty() && p.equals(".."))
                stack.pop();
            else if(!p.equals(".") && !p.equals("") && !p.equals(".."))
                stack.push(p);
        }

        List<String> list = new ArrayList<>(stack);
        return "/" + String.join("/", list);
    }
}
