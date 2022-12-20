public class Multithread extends Thread {
	public static void main (String[]args) {
		for (int i=0; i<10; i++) {
			// Local variable defined in an enclosing scope must be final
			final String count = i+"";
			Thread t = new Thread(() -> {
				Thread.currentThread().setName(count);
				System.out.println("Thread "+Thread.currentThread().getName()+" is created.");
			});
			t.start();
		}
	}
}
