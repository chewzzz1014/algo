
public class TestArrayQueue {
	public static void main (String[] args) {
	      ArrayQueue queue = new ArrayQueue(4);

	      queue.enqueue("CARROTS");
	      queue.enqueue("ORANGES");
	      queue.enqueue("RAISINS");
	      queue.enqueue("PICKLES");
	      System.out.println("queue.size(): " + queue.size() + "\tqueue.getFront(): " + queue.getFront());
	      System.out.println("queue.dequeue(): " + queue.dequeue());
	      System.out.println("queue.dequeue(): " + queue.dequeue());
	      System.out.println("queue.dequeue(): " + queue.dequeue());

	      System.out.println("queue.size(): " + queue.size() + "\tqueue.getFront(): " + queue.getFront());
	      queue.enqueue("WALNUTS");
	      queue.enqueue("OYSTERS");
	      queue.enqueue("BANANAS");
	      System.out.println("queue.size(): " + queue.size() + "\tqueue.getFront(): " + queue.getFront());
	      System.out.println("queue.dequeue(): " + 	queue.dequeue());
	      System.out.println("queue.dequeue(): " + 	queue.dequeue());
	      System.out.println("queue.dequeue(): " + 	queue.dequeue());
	      System.out.println("queue.dequeue(): " + 	queue.dequeue());
	      System.out.println("queue.dequeue(): " + 	queue.dequeue());
	   }
	 }
