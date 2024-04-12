package progSkills;

public class AvgSalary {
    public double average(int[] salary) {
        int mi = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;
        double total = 0;

        for(int s : salary) {
            mi = Math.min(mi, s);
            mx = Math.max(mx, s);
            total += s;
        }

        return (total - mi - mx) / (salary.length - 2);
    }
}
