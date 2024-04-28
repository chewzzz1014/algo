package Tree;

import List.Position;

public class ParentheticRepresentation {
    
    // print parenthetic representation where the children of a node is inside the parnethesis right after the node
    // Eg: Electronics R’Us (R&D, Sales (Domestic (Canada, Overseas (Africa))), Manufacturing (TV, CD, Tuner))
    public static <T> void parenthesize(Tree<T> T, Position<T> p) {
        System.out.print(p.getElement());

        if(T.isInternal(p)) {
            boolean firstTime = true;
            for(Position<T> c : T.children(p)) {
                System.out.print((firstTime ? " (" : ", "));
                firstTime = false;
                parenthesize(T, c);
            }
            System.out.print(")");
        }
    }
}
