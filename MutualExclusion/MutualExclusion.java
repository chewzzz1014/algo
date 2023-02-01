// Chew Zi Qing 212360
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

// simulating mutex using Java
public class MutualExclusion extends Thread{

	// create server thread and 2 client threads.
	public static void main (String[]args) throws InterruptedException {
		// semaphore value = 1. Only one thread is executed at any given time
		Semaphore s = new Semaphore(1);
		// create server and clients and pass the semaphore
		Server server = new Server(s, "", 20);
		Client c1 =  new Client(server, s, "", 10);
		Client c2 = new Client(server, s, "", 10);
		
		// set name of client 
		c1.setName("Client 1");
		c2.setName("Client 2");
		
		// start server and client 1. 
		//Make sure client 1 is completed before starting client 2
		server.start();
		c1.start();
		c1.join();
		
		c2.start();
		c2.join();
			
		System.out.println("Simulation ends");
	}
}

// Server class that's able to pong to client
class Server extends Thread{
	Semaphore s;
	String msg;
	int count;
	
	// constructor
	public Server(Semaphore s, String msg, int count) {
		this.s = s;
		this.msg = msg;
		this.count = count;
	}
	
	public void run(){
	}

	// pong back to client
	// apply lock on the method to prevent 2 threads access at same time
	public void pong(int i, String clientName, ReentrantLock l) {
		l.lock();
		try {
	        msg = "Server pong " + i + " to " + clientName;
			System.out.println(msg);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			l.unlock();
		}
	}
}

class Client extends Thread{
	Server server;
	Semaphore s;
	String msg;
	int count;
	ReentrantLock l = new ReentrantLock();
	
	// constructor
	public Client(Server server, Semaphore s, String msg, int count) {
		this.server = server;
		this.s = s;
		this.msg = msg;
		this.count = count;
	}
	
	// running each client to ping 10 times
	// apply lock on the method to prevent 2 threads access at same time
	public void run(){
		for(int i=1; i<=count; i++) {
			try {
				l.lock();
				this.ping(i);
				server.pong(i, Thread.currentThread().getName(), l); 
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				l.unlock();
			}
		}
	}
	
	// ping to server
	// apply lock on the method to prevent 2 threads access at same time
	public synchronized void ping(int i) {
		l.lock();
		try {
			msg = Thread.currentThread().getName() + " ping " + i ;
			System.out.println(msg);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			l.unlock();
		}
	}
}

