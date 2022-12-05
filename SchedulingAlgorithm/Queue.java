
public class Queue {
	private Object[] objQ;
	private int frontIdx, backIdx, size;
	
	public Queue (int capacity) {
		objQ = new Object[capacity];
		frontIdx = 0;
		backIdx = capacity - 1;
		size = 0;
	}
	
	public void enqueue(Object obj) {
		ensureCapacity();
		backIdx = (backIdx+1) % objQ.length;
		objQ[backIdx] = obj;
		size ++;
	}
	
	public Object dequeue() {
		Object front;
		
		if (size == 0)
			throw new IllegalStateException("queue is empty");
		
		front = objQ[frontIdx];
		frontIdx = (frontIdx + 1) % objQ.length;
		size --;
		
		return front;
	}
	
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
	
	public String toString() {
		String output = "";
		for (int i=0; i<size; i++) {
			output += objQ[i].toString() + " ";
		}
		return output;
	}
	
	public int size() {
		return size;
	}
	
	public Object getItem(int idx) {
		return objQ[idx];
	}
}
