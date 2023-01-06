//import javax.lang.model.SourceVersion.isName;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SearchSortPartC {
	public static void main (String[]args) throws IOException{
		
		int lineNum = 1;
		String line;
		String FILEPATH = 
				"C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_Sort_Search\\input.txt";
		BufferedReader reader = new BufferedReader(new FileReader(FILEPATH));
		
		ArrayList<String> kw = new JavaKeywords().getKeyWords();
		Map<String, Integer> mapWithOccurence = new HashMap<>();
		Map<String, ArrayList<Integer>> mapWithLineNums = new HashMap<>();
		
		while((line = reader.readLine()) != null) {
			String[] allWordsInSentence = line.split(" |\\. |, ");
			
			// not an empty line
			// check all words in the line
			if (allWordsInSentence.length > 0) {
				for(String s: allWordsInSentence) {
					if (kw.contains(s.toLowerCase())){		
						if (mapWithOccurence.containsKey(s)) {
							mapWithOccurence.put(s, mapWithOccurence.get(s)+1);
							
							ArrayList<Integer> l = mapWithLineNums.get(s);
							l.add(lineNum);
							mapWithLineNums.put(s, l);
						}
						else {
							mapWithOccurence.put(s, 1);
							mapWithLineNums.put(s, new ArrayList<Integer>(Arrays.asList(lineNum)));
						}
					}
				}	
			}
			lineNum ++;
		}
		reader.close();

		// TreeMap will sort the keys in map
		TreeMap<String, Integer> treeMap1 = new TreeMap<>(mapWithOccurence);
		TreeMap<String, ArrayList<Integer>> treeMap2 = new TreeMap<>(mapWithLineNums);
		
		for (String s : treeMap1.keySet()) {
			// exclude [ ] of ArrayList's toString
			String allLineNum = treeMap2.get(s).toString();
			allLineNum = allLineNum.substring(1, allLineNum.length()-1);
			
		    System.out.println(s +" appeared "+ treeMap1.get(s) + " times in lines "+ allLineNum);
		    System.out.println();
		}
	}
}
