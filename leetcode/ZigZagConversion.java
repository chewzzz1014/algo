public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows<=1) return s;
        
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i=0; i<sb.length; i++)
            sb[i] = new StringBuilder();

        int idx = 0;
        int direction = -1;
        char[] chars = s.toCharArray();
        for(char c:chars) {
            sb[idx].append(c);
            if(idx==0 || idx==numRows-1) direction = 0 - direction;
            idx += direction;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder ele: sb) res.append(ele);
        return res.toString();
    }
}
