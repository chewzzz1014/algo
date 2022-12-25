
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class MutualExclusion extends Thread{
	
	// message to be send/received
	String msg = "";
	
	public static void main (String[]args) throws InterruptedException {
		Semaphore s = new Semaphore(1);
		Server server = new Server(s, "", 20);
		Client c1 =  new Client(server, s, "", 10);
		Client c2 = new Client(server, s, "", 10);
		
		c1.setName("Client 1");
		c2.setName("Client 2");
		
		server.start();
		c1.start();
		c1.join();
		
		c2.start();
		c2.join();
			
		 System.out.println("Simulation ends");
	}
}

class Server extends Thread{
	Semaphore s;
	String msg;
	int count;
	
	public Server(Semaphore s, String msg, int count) {
		this.s = s;
		this.msg = msg;
		this.count = count;
	}
	
	public void run(){
	}

	
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
	
	public Client(Server server, Semaphore s, String msg, int count) {
		this.server = server;
		this.s = s;
		this.msg = msg;
		this.count = count;
	}
	
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

