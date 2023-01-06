//import javax.lang.model.SourceVersion.isName;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SearchSortPartA {
	public static void main (String[]args) throws IOException{
		
		int lineNum = 1;
		String line;
		String FILEPATH = 
				"C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_Sort_Search\\input.txt";
		BufferedReader reader = new BufferedReader(new FileReader(FILEPATH));
		
		ArrayList<String> kw = new JavaKeywords().getKeyWords();
		Map<String, Integer> map = new HashMap<>();
		
		while((line = reader.readLine()) != null) {
			String[] allWordsInSentence = line.split(" |\\. |, ");
			
			// not an empty line
			// check all words in the line
			if (allWordsInSentence.length > 0) {
				for(String s: allWordsInSentence) {
					if (kw.contains(s.toLowerCase())){
						if (map.containsKey(s))
							map.put(s, map.get(s)+1);
						else
							map.put(s, 1);
					}
				}
			}
			lineNum ++;
		}
		reader.close();

		// TreeMap will sort the keys in map
		TreeMap<String, Integer> treeMap = new TreeMap<>(map);
		
		for (var entry : treeMap.entrySet()) {
		    System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		//String[] allKeywords = treeMap.keySet().toArray(new String[treeMap.size()]);
	}
}
