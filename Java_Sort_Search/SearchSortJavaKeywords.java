//import javax.lang.model.SourceVersion.isName;
import java.io.*;

public class SearchSortJavaKeywords {
	public static void main (String[]args) throws IOException{
		String line;
		String FILEPATH = "C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_Sort_Search\\JavaKeyword.txt";
		
		BufferedReader reader = new BufferedReader(new FileReader(FILEPATH));
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		reader.close();
	}
}
