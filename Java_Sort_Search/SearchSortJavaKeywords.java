//import javax.lang.model.SourceVersion.isName;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SearchSortJavaKeywords {
	public static void main (String[]args) throws IOException{
		
		String line;
		String FILEPATH = 
				"C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_Sort_Search\\input.txt";
		BufferedReader reader = new BufferedReader(new FileReader(FILEPATH));
		
		ArrayList<String> kw = new JavaKeywords().getKeyWords();
		Map<Integer, Integer> map = new HashMap<>();
		
		while((line = reader.readLine()) != null) {
			String[] allWordsInSentence = line.split(" |\\. |, ");
			System.out.println(Arrays.toString(allWordsInSentence));
			
			// not an empty line
			if (allWordsInSentence.length > 0) {
				for(String s: allWordsInSentence) {
					System.out.println(s + " " + kw.contains(s.toLowerCase()));
				}
			}
		}

		TreeMap<Integer, Integer> treeMap = new TreeMap<>(map);
		
		// record all processes arrival time in array
		String[] allKeywords = treeMap.keySet().toArray(new String[treeMap.size()]);
	}
}
