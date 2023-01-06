import java.io.*;
import java.util.*;

public class JavaKeywords{
	
	private BufferedReader reader;
	private String line;
	private String FILEPATH = 
				"C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_Sort_Search\\JavaKeyword.txt";
	private ArrayList<String> keywords = new ArrayList<>();
	
	public JavaKeywords() throws IOException {
		reader = new BufferedReader(new FileReader(FILEPATH));
		while ((line = reader.readLine()) != null) {
			keywords.add(line.trim());
		}
		reader.close();
	}
	
	public ArrayList<String> getKeyWords(){
		return keywords;
	}
}
