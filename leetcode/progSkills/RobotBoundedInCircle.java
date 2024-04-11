package progSkills;

public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        // NESW -> 0123
        int[][] movements = {{0, 1}, {1, 0}, {0, -1}, { -1, 0}};
        int x=0, y=0;
        int direction = 0;

        for(int i=0; i<instructions.length(); i++) {
            switch(instructions.charAt(i)) {
                case 'G':
                    x += movements[direction][0];
                    y += movements[direction][1];
                    break;
                case 'L':
                    direction = (direction+3)%4;
                    break;
                case 'R':
                    direction = (direction+1)%4;
                    break;
            }
        }
        return x==0 && y==0 || direction>0;
    }
}
