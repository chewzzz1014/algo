//Chew Zi Qing 212360
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//display a list in alphabetical order of the unique Java keywords used in the input.txt
//display also number of occurence and line number
public class SearchSortPartC {
	public static void main (String[]args) throws IOException{
		// to track the current line number
		int lineNum = 1;
		// data field for reading keywords from file
		String line;
		String FILEPATH = 
				"C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_Sort_Search\\input.txt";
		BufferedReader reader = new BufferedReader(new FileReader(FILEPATH));
		
		// arraylist that stores all the Java keywords
		ArrayList<String> kw = new JavaKeywords().getKeyWords();
		// map store keywords and their #occurence
		Map<String, Integer> mapWithOccurence = new HashMap<>();
		// map store keywords and the line number they appear in
		Map<String, ArrayList<Integer>> mapWithLineNums = new HashMap<>();
		
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
						if (mapWithOccurence.containsKey(s)) {
							// increase number of occurence
							mapWithOccurence.put(s, mapWithOccurence.get(s)+1);
							
							// add the current line number to its arraylist of line numbers
							ArrayList<Integer> l = mapWithLineNums.get(s);
							l.add(lineNum);
							mapWithLineNums.put(s, l);
						}
						else {
							// add a new map item
							mapWithOccurence.put(s, 1);
							mapWithLineNums.put(s, new ArrayList<Integer>(Arrays.asList(lineNum)));
						}
					}
				}	
			}
			lineNum ++;
		}
		reader.close();

		// TreeMap will sort the keys in map by ascending order
		TreeMap<String, Integer> treeMap1 = new TreeMap<>(mapWithOccurence);
		TreeMap<String, ArrayList<Integer>> treeMap2 = new TreeMap<>(mapWithLineNums);
		
		// display all keywords appeared, #occurences and all line numbers appeared
		for (String s : treeMap1.keySet()) {
			// exclude [ ] of ArrayList's toString
			String allLineNum = treeMap2.get(s).toString();
			allLineNum = allLineNum.substring(1, allLineNum.length()-1);
			
		    System.out.println(s +" appeared "+ treeMap1.get(s) + " times in lines "+ allLineNum);
		    System.out.println();
		}
	}
}
