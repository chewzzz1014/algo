// Chew Zi Qing 212360

//import javax.lang.model.SourceVersion.isName;
import java.io.*;
import java.util.*;

import List.ArrayList;

// display a list in alphabetical order of the unique Java keywords used in the input.txt
public class SearchSortPartA {
	public static void main (String[]args) throws IOException{
		// data field for reading keywords from file
		String line;
		String FILEPATH = 
				"C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_Sort_Search\\input.txt";
		BufferedReader reader = new BufferedReader(new FileReader(FILEPATH));
		
		// arraylist that stores all the Java keywords
		ArrayList<String> kw = new JavaKeywords().getKeyWords();
		// arraylist that stores keywords appeared in the program
		ArrayList<String> appearedKeywords = new ArrayList<>();
		
		// read every line from input.txt
		while((line = reader.readLine()) != null) {
			// split sentence into words
			String[] allWordsInSentence = line.split(" |\\. |, ");
			
			// if it's not an empty line
			if (allWordsInSentence.length > 0) {
				// check all words in the line
				for(String s: allWordsInSentence) {
					// if it's a Java keyword
					if (kw.contains(s.toLowerCase())){
						// if it's its first appearance, add to arraylist
						if (!appearedKeywords.contains(s))
							appearedKeywords.add(s);
					}
				}
			}
		}
		reader.close();
		
		// sort keywords appeared in the program
		Collections.sort(appearedKeywords);
		
		// display them
		for (String s: appearedKeywords)
			System.out.println(s);
	}
}
