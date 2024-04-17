public class EnglishRuler {
    
    public static void drawRuler(int nInches, int majorLength) {
        drawLine(majorLength, 0);
        for(int i=1; i<nInches, i++) {
            drawInterval(majorLength-1);
            drawLine(majorLength, i);
        }
    }

    private static void drawInterval(int centralLength) {
        if(centralLength >= 1) {
            drawInterval(centralLength - 1);
            drawLine(centralLength);
            drawInterval(centralLength - 1);
        }
    }

    private static void drawLine(int tickLength, int tickLabel) {
        for(int i=0; i<tickLength; i++)
            System.out.print(" " + tickLabel);
        if(tickLabel >= 0)
            System.out.println(" " + tickLabel);
        System.out.println("\n");
    }

    private static void drawLine(int tickLength) {
        drawLine(tickLength, -1);
    }
}
