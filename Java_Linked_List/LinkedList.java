// Chew Zi Qing
// 212360

// generic linked list
// methods: getData, addFirst, addLast, add, removeFirst,
// removeLast, remove, toString, indexOf
public class LinkedList <T> {
	Node<T> first, last;
	int size = 0;
	
	public LinkedList() {
		
	}
	
	// get node data at a specific index
	public T getData(int idx) {
		if (size == 0)
			return null;
		else {
			Node<T> current = first;
			
			for(int i=0; i<idx; i++) {
				if (current.link != null)
					current = current.link;
			}
			return current.data;
		}
	}
	
	// add node to the front of list
	public void addFirst(T o) {
		Node<T> newNode = new Node<T>(o);
		newNode.link = first;
		first = newNode;
		size ++;
		
		if(last == null)
			last = first;
	}
	
	// add node to the back of list
	public void addLast(T o) {
		if (last == null)
			first = last = new Node<T>(o);
		else {
			last.link = new Node<T>(o);
			last = last.link;
		}
		size++;
	}
	
	// add node at specific index
	public void add(int idx, T o) {
		if (idx == 0)
			addFirst(o);
		else if (idx >= size)
			addLast(o);
		else {
			Node<T> current = first;
			for (int i=1; i<idx; i++) 
				current = current.link;
			Node<T> temp = current.link;
			current.link = new Node<T>(o);
			(current.link).link = temp;
			size ++;
		}
	}
	
	// remove first node
	public T removeFirst() {
		if (size == 0)
			return null;
		else {
			Node<T> temp = first;
			first = first.link;
			size --;
			if (first == null)
				last = null;
			return temp.data;
		}
	}
	
	// remove last node
	public T removeLast() {
		if (size == 0)
			return null;
		else {
			Node<T> temp = last;
			Node<T> previous = first;
			
			for (int i=0; i<size-2; i++) {
				previous = previous.link;
			}
			previous.link = null;
			last = previous;
			size --;
			return temp.data;
		}
	}
	
	// remove node at a specific index
	public T remove(int idx) {
		if ((idx<0)||(idx>=size))
			return null;
		else if (idx == 0)
			return removeFirst();
		else if (idx == size-1)
			return removeLast();
		else {
			Node<T> previous = first;
			for (int i=1; i<idx; i++) 
				previous = previous.link;
			
			Node<T> current = previous.link;
			previous.link = current.link;
			size --;
			return current.data;
		}
	}
	
	// convert the contents of linked list to string
	public String toString() {
		StringBuffer result = new StringBuffer("");
		Node<T> current = first;
		
		if(size==0)
			return "[ ]";
		
		for(int i=0; i<size; i++) {
			result.append(current.data);
			current = current.link;
			
			result.append("\n\n");
		}
		return result.toString();
	}
	
	// find the index of a node with given flightNum/seatNum
	public int indexOf(String target, int n) {
		Node<T> current = first;
		int index = 0;
		
		if (target.equals("flight")) {
			while(current != null) {
				Flight f = (Flight)current.data;
				if ( f.flightNum == n)
					return index;
				current = current.link;
				index ++;
			}
		}else {
			while(current != null) {
				Passenger p = (Passenger)current.data;
				if ( p.seatNum == n)
					return index;
				current = current.link;
				index ++;
			}
		}
		return -1;
	}
	
	
}
