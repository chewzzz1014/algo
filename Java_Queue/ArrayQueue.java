
public class ArrayQueue implements Queue {
	private Object[] objQ;
	private int frontIdx, backIdx, size;
	
	public ArrayQueue (int capacity) {
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
		
		if (isEmpty())
			throw new IllegalStateException("queue is empty");
		
		front = objQ[frontIdx];
		frontIdx = (frontIdx + 1) % objQ.length;
		size --;
		
		return front;
	}
	
	public boolean isFull() {
		return size == objQ.length;
	}
	
	private void ensureCapacity() {
		if(isFull()) {
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
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public Object getFront() {
		Object front = null;
		if (isEmpty())
			throw new IllegalStateException("queue is empty");
		
		front = objQ[frontIdx];
		return front;
	}
	
	public int size() {
		return size;
	}
	
	
}
