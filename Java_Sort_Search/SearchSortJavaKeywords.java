//import javax.lang.model.SourceVersion.isName;
import java.io.*;
import java.util.ArrayList;

public class SearchSortJavaKeywords {
	public static void main (String[]args) throws IOException{
		ArrayList<String> kw = new JavaKeywords().getKeyWords();
		
		
		for(int i =0; i<kw.size(); i++) {
			System.out.println(kw.get(i));
		}
	}
}
