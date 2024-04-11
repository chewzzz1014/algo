package progSkills;

public class RobotReturnOrigin {
    public boolean judgeCircle(String moves) {
        int coorI = 0, coorJ = 0;

        for(int i = 0; i<moves.length(); i++) {
            switch(moves.charAt(i)) {
                case 'L':
                    coorI--;
                    break;
                case 'R':
                    coorI++;
                    break;
                case 'U':
                    coorJ++;
                    break;
                case 'D':
                    coorJ--;
                    break;
            }
        }
        return coorI == 0 && coorJ == 0;
    }
}
