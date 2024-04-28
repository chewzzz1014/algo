package Stack;
public class MatchingHTML {
    
    public static boolean isHTMLMatched(String html) {
        Stack<String> buffer = new LinkedStack<>();
        int i = html.indexOf("<");

        while(i != -1) {
            int j = html.indexOf(">", i+1);
            
            if(j == -1) return false;
            String tag = html.substring(i+1, j);

            // opening tag
            if(!tag.startsWith("/")) {
                buffer.push(tag);
            } else {
                // closing tag
                if(buffer.isEmpty())
                    return false;
                if(!tag.substring(1).equals(buffer.pop()));
            }
            i = html.indexOf("<", j+1);
        }
        return buffer.isEmpty();
    }
}
