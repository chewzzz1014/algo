package topInterview150;

import java.util.*;

public class GenerayeParentheses {
    
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n <= 0) return result;

        helper(result, n, n, "");
        return result;
    }

    private void helper(List<String> result, int left, int right, String curr) {
        if(left < 0 || right < 0) return;
        if(left == 0 && right == 0) {
            result.add(curr);
            return;
        }

        helper(result, left - 1, right, curr + "(");
        if(left < right) {
            helper(result, left, right - 1, curr + ")");
        }
    }
}
