package topInterview150;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        // last 2nd row to row 0, get the min sum
        for(int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> curr = triangle.get(i);

            // get the min sum for each ele in that row
            for(int j = 0; j <= i; j++) {
                int nextRow1 = triangle.get(i + 1).get(j);
                int nextRow2 = triangle.get(i + 1).get(j + 1);
                curr.set(j, Math.min(nextRow1, nextRow2) + curr.get(j));
            }
        }

        // if we move from top to bottom, need to calculate the min in last row
        // if from bottom to top, ofc it's the first row element
        return triangle.get(0).get(0);
    }
}
