// class for ensuring mutual exclusion by locking
import java.util.concurrent.locks.ReentrantLock;

public class MutualExclusion extends Thread {
	
	// message to be send/received
	String msg = "";
	
	public static void main (String[]args) {
		Server server = new Server();
		Client client1 = new Client("1", server);
		Client client2 = new Client("2", server);
		
		new Thread(server).start();
		new Thread(client1).start();
		new Thread(client2).start();
	}
	
	// inner class. Server that's able to pong to client
	static class Server implements Runnable{
		String msg = "";
		ReentrantLock reentrantlock = new ReentrantLock();
		public Server() {
			
		}
		public void run() {
		
		}
		
		private void receiveMsg(String receivedMsg) {
			reentrantlock.lock();
			try {
				this.msg = receivedMsg;
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				reentrantlock.unlock();
			}
		}
		
		private void replyMsg() {
			
		}
	}
	
	// inner class. Client that's able ping to client
	static class Client implements Runnable{
		String id;
		Server server;
		private ReentrantLock reentrantlock = new ReentrantLock();
		
		public Client(String id, Server server) {
			this.id = id;
			this.server = server;
		}
		public void run() {
			
		}
		
		private void sendMsg() {
			reentrantlock.lock();
			try {
				System.out.printf("Client %1s ping\n", id);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				reentrantlock.unlock();
			}
		}
		
		private void waitForReply() {
			
		}
	}
}
