package progSkills;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    public int calPoints(String[] operations) {
        List<Integer> scores = new ArrayList<>();
        int totalScore = 0;

        for(String op : operations) {
            switch(op) {
                case "+":
                    scores.add(scores.get(scores.size()-1) + scores.get(scores.size()-2));
                    break;
                case "D":
                    scores.add(scores.get(scores.size()-1) * 2);
                    break;
                case "C":
                    scores.remove(scores.size()-1);
                    break;
                default:
                    scores.add(Integer.parseInt(op));
                    break;
            }
        }

        for(int s : scores) totalScore += s;
        return totalScore;
    }
}
