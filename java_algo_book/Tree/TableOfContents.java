package Tree;

import List.ArrayList;
import List.Position;

public class TableOfContents {
    
    // return spaces of length d
    public static String spaces(int d) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<d; i++)
            sb.append(" ");
        return sb.toString();
    }

    // print preorder unindent rperesentation of toc
    public static <T> void printUnindented(AbstractTree<T> T) {
        for(Position<T> p : T.preorder())
            System.out.println(p.getElement());
    }

    // print preorder representation of subtree T rooted at p having depth d
    public static <T> void printPreorderIndent(Tree<T> T, Position<T> p, int d) {
        System.out.println(spaces(2*d) + p.getElement());
        for(Position<T> c : T.children(p))
            printPreorderIndent(T, c, d+1);
    }

    // print labeled representation of subtree T rooted at p having depth p
    public static <T> void printPreorderLabeled(Tree<T> T, Position<T> p, ArrayList<Integer> path) {
        int d = path.size();

        // print indentation
        System.out.print(spaces(2*d));

        // print label of item. eg. 2.1, 2.1.3
        for(int i=0; i<d; i++)
            System.out.println(path.get(i) + (i == d-1 ? " " : "."));

        // print toc item name
        System.out.println(p.getElement());

        // add path entry for first child
        path.add(1); 

        for(Position<T> c : T.children(p)) {
            printPreorderLabeled(T, c, path);
            path.set(d, 1 + path.get(d));
        }

        // restore path to its incoming state
        path.remove(d);
    }
}
