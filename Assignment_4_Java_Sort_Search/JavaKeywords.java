// Chew Zi Qing 212360
import java.io.*;
import java.util.*;

import List.ArrayList;

//class that read all Java keywords from JavaKeyword.txt and put in arraylist
public class JavaKeywords{
	
	// data field for reading keywords from file
	private BufferedReader reader;
	private String line;
	private String FILEPATH = 
				"C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_Sort_Search\\JavaKeyword.txt";
	// arraylist that stores all keywords
	private ArrayList<String> keywords = new ArrayList<>();
	
	// insert all Java keywords into arraylist
	public JavaKeywords() throws IOException {
		reader = new BufferedReader(new FileReader(FILEPATH));
		while ((line = reader.readLine()) != null) {
			keywords.add(line.trim());
		}
		reader.close();
	}
	
	// return arraylist of keywords
	public ArrayList<String> getKeyWords(){
		return keywords;
	}
}
