//Chew Zi Qing 212360
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//display a list in alphabetical order of the unique Java keywords used in the input.txt
//display also number of occurence
public class SearchSortPartB {
	public static void main (String[]args) throws IOException{
		// data field for reading keywords from file
		String line;
		String FILEPATH = 
				"C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_Sort_Search\\input.txt";
		BufferedReader reader = new BufferedReader(new FileReader(FILEPATH));
		
		// arraylist that stores all the Java keywords
		ArrayList<String> kw = new JavaKeywords().getKeyWords();
		// map store keywords and their #occurence
		Map<String, Integer> map = new HashMap<>();
		
		// read every line from input.txt
		while((line = reader.readLine()) != null) {
			// split sentence into words
			String[] allWordsInSentence = line.split(" |\\. |, ");
			
			// if it's not an empty line
			if (allWordsInSentence.length > 0) {
				//check all words in the line
				for(String s: allWordsInSentence) {
					// if it's a Java keyword
					if (kw.contains(s.toLowerCase())){
						// keyword haven't added to map?
						if (map.containsKey(s))
							// increase number of occurence
							map.put(s, map.get(s)+1);
						else
							// add a new map item
							map.put(s, 1);
					}
				}
			}
		}
		reader.close();

		// TreeMap will sort the keys in map in ascending order
		TreeMap<String, Integer> treeMap = new TreeMap<>(map);
		
		// display keywords and their #occurence
		for (var entry : treeMap.entrySet()) {
		    System.out.println(entry.getKey() + " appeared " + entry.getValue()+ "times");
		}
	}
}
