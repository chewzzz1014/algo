
public interface Queue {
	public void enqueue(Object obj);
	public Object getFront();
	public Object dequeue();
	public int size();
}
