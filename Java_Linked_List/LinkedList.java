// Chew Zi Qing
// 212360

public class LinkedList <T> {
	Node<T> first, last;
	int size = 0;
	
	public LinkedList() {
		
	}
	
	public T getFirst(){
		if(size==0)
			return null;
		else
			return first.data;
	}
	
	public T getLast() {
		if(size==0)
			return null;
		else
			return last.data;
	}
	
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
	
	public void addFirst(T o) {
		Node<T> newNode = new Node<T>(o);
		newNode.link = first;
		first = newNode;
		size ++;
		
		if(last == null)
			last = first;
	}
	
	public void addLast(T o) {
		if (last == null)
			first = last = new Node<T>(o);
		else {
			last.link = new Node<T>(o);
			last = last.link;
		}
		size++;
	}
	
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
