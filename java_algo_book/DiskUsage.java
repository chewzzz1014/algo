import java.io.File;

public class DiskUsage {

    public static long diskUsage(File root) {
        long total = root.length();

        if(root.isDirectory()) {
            for(String childname : root.list()) {
                File child = new File(childname);
                total += diskUsage(child);
            }
        }

        System.out.println(total + "\t" + root);
        return total;
    }
}