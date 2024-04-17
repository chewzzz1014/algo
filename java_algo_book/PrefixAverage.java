public class PrefixAverage {
    

    public static double[] prefixAverage1(double[] x) {
        int n = x.length;
        double[] result = new double[n];

        for(int i=0; i<n; i++) {
            double total = 0;
            for(int j=0; j<=i; j++)
                total += x[j];
            result[i] = total / (i+1);
        }
        return result;
    }

    public static double[] prefixAverage2(double[] x) {
        int n = x.length;
        double[] result = new double[n];
        double total = 0;

        for(int i=0; i<n; i++) {
            total += x[i];
            result[i] = total / (i+1);
        }
        return result;
    }

}
