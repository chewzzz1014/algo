package progSkills;

public class CheckIsStraight {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 2) return true;

        // check the slop of every next 2 points
        // (y1-y0)/(x1-x0) == (y2-y1)/(x2-x1)

        int x0 = coordinates[0][0],
            y0 = coordinates[0][1],
            x1 = coordinates[1][0],
            y1 = coordinates[1][1];
        int dx = x1 - x0;
        int dy = y1 - y0;

        for(int[] c : coordinates) {
            int x = c[0], y = c[1];
            if(dx * (y - y1) != dy * (x - x1)) return false;
        }

        return true;
    }
}
