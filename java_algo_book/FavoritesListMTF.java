// move to front heuristics
// each time we access an element we move it all the way to the front of the list.
// with the hope that this element will be accessed again in the near future

public class FavoritesListMTF<T> extends FavoritesList<T> {
    
    PositionalList<Item<T>> list = new LinkedPositionalList<>();

    protected void moveUp(Position<Item<T>> p) {
        if(p != list.first())
            list.addFirst(list.remove(p));
    }

    public Iterable<T> getFavorites(int k) throws IllegalArgumentException {
        if(k<0 || k>size())
            throw new IllegalArgumentException("Invalid k");

        // make a copy of original list
        PositionalList<Item<T>> temp = new LinkedPositionalList<>();
        for(Item<T> item : list)
            temp.addLast(item);
        
        // find, report, remove element with largest count
        PositionalList<T> result = new LinkedPositionalList<>();
        for(int i=0; i<k; i++) {
            Position<Item<T>> highPos = temp.first();
            Position<Item<T>> walk = temp.after(highPos);
            while(walk != null) {
                if(count(walk) > count(highPos))
                    highPos = walk;
                walk = temp.after(walk);
            }
            // found element with highest count
            result.addLast(value(highPos));
            temp.remove(highPos); 
        }

        return result;
    }
}
