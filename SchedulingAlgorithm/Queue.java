// Chew Zi Qing 212360

// to be used for processes' FIFO queue 
public class Queue {
	private Object[] objQ;
	private int frontIdx, backIdx, size;
	
	// constructor that builds a queue with the given size
	public Queue (int capacity) {
		objQ = new Object[capacity];
		frontIdx = 0;
		backIdx = capacity - 1;
		size = 0;
	}
	
	// add item to the back of queue
	public void enqueue(Object obj) {
		ensureCapacity();
		backIdx = (backIdx+1) % objQ.length;
		objQ[backIdx] = obj;
		size ++;
	}
	
	// remove item from the front of queue
	public Object dequeue() {
		Object front;
		
		if (size == 0)
			throw new IllegalStateException("queue is empty");
		
		front = objQ[frontIdx];
		frontIdx = (frontIdx + 1) % objQ.length;
		size --;
		
		return front;
	}
	
	// resize the queue if number of items is more than queue capacity
	private void ensureCapacity() {
		if(size == objQ.length) {
			Object[] oldQ = objQ;
			
			objQ = new Object[2 * oldQ.length];
			
			for (int i=0; i < oldQ.length; i++) {
				objQ[i] = oldQ[frontIdx];
				frontIdx = (frontIdx + 1) % oldQ.length;
			}
			frontIdx = 0;
			backIdx = oldQ.length - 1;
		}
	}
	
	// print all items inside the queue
	public String toString() {
		String output = "";
		for (int i=0; i<size; i++) {
			output += objQ[i].toString();
		}
		return output;
	}
	
	// get queue size
	public int size() {
		return size;
	}
	
	// get item at a specific index
	public Object getItem(int idx) {
		return objQ[idx];
	}
}
