package topInterview150;

import java.util.*;

class Node {
    String num;
    double val;

    Node(String num, double val) {
        this.num = num;
        this.val = val;
    }
}

class EvaluateEquation {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> map = new HashMap<>();

        // build the graph structure
        for(int i=0; i<equations.size(); i++) {
            List<String> eq = equations.get(i);
            if(!map.containsKey(eq.get(0))) {
                map.put(eq.get(0), new ArrayList<>());
            }
            map.get(eq.get(0)).add(new Node(eq.get(1), values[i]));

            if(!map.containsKey(eq.get(1))) {
                map.put(eq.get(1), new ArrayList<>());
            }
            map.get(eq.get(1)).add(new Node(eq.get(0), 1/values[i]));
        }

        double[] result = new double[queries.size()];
        for(int i=0; i<result.length; i++) {
            String num1 = queries.get(i).get(0);
            String num2 = queries.get(i).get(1);
            result[i] = dfs(num1, num2, 1, map, new HashSet<>());
        }
        return result;
    }

    private double dfs(String start, String end, double value, Map<String, List<Node>> map, HashSet<String> visited) {
        if(!map.containsKey(start)) return -1;

        if(visited.contains(start)) return -1;

        if(start.equals(end)) return value;

        visited.add(start);

        for(Node next : map.get(start)) {
            double sub = dfs(next.num, end, value*next.val, map, visited);
            if(sub != -1.0) {
                return sub;
            }
        }

        visited.remove(start);

        return -1;
    }
}