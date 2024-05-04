package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class WordCount {

    public static void main(String[] args) {
        Map<String,Integer> freq = new HashMap<>();
        Scanner scanner = new Scanner(System.in).useDelimiter("[^a-zA-Z]+");

        while(scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            Integer count = freq.get(word);
            if(count == null)
                count = 0;
            freq.put(word, 1 + count);
        }

        int maxCount = 0;
        String maxWord = "no word";
        for(Entry<String, Integer> entry : freq.entrySet()) {
            if(entry.getValue() > maxCount) {
                maxWord = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        System.out.print("The most frequent word is '" + maxWord);
        System.out.println("' with " + maxCount + " occurrences.");
        scanner.close();
    }
    
}
