package assessments;

public class BinaryToDecimal {

    public int binaryToDecimal(String binaryString) {
        int n = binaryString.length();
        int base10 = 0;

        for(int i=n-1; i>=0; i--) {
            base10 += (binaryString.charAt(i) - '0') * Math.pow(2, n-1-i);
        }
        return base10;
    }
}