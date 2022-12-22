// Chew Zi Qing 212360
public class Multithread extends Thread {
	public static void main (String[]args) throws InterruptedException{
		for (int i=1; i<=10; i++) {
			
			// Local variable defined in an enclosing scope must be final!
			final String count = i+"";
			
			// create thread and assign name
			Thread t = new Thread(() -> {
				Thread.currentThread().setName(count);
				// print output that displays thread name
				System.out.println("Thread "
								   + Thread.currentThread().getName()
								   +" is created.");
			});
			
			// start the thread
			t.start();
			
			// make sure the current thread is completed before starts next
			t.join();
		}
	}
}
