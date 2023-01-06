//import javax.lang.model.SourceVersion.isName;
import java.io.*;
import java.util.*;

public class SearchSortPartA {
	public static void main (String[]args) throws IOException{
		
		String line;
		String FILEPATH = 
				"C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_Sort_Search\\input.txt";
		BufferedReader reader = new BufferedReader(new FileReader(FILEPATH));
		
		ArrayList<String> kw = new JavaKeywords().getKeyWords();
		ArrayList<String> appearedKeywords = new ArrayList<>();
		
		while((line = reader.readLine()) != null) {
			String[] allWordsInSentence = line.split(" |\\. |, ");
			
			// not an empty line
			// check all words in the line
			if (allWordsInSentence.length > 0) {
				for(String s: allWordsInSentence) {
					if (kw.contains(s.toLowerCase())){
						if (!appearedKeywords.contains(s))
							appearedKeywords.add(s);
					}
				}
			}
		}
		reader.close();
		
		Collections.sort(appearedKeywords);
		
		for (String s: appearedKeywords)
			System.out.println(s);
	}
}
