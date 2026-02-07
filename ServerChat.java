import java.io.*;
import java.net.*;
import java.util.*;

class OneClient extends Thread {
	Socket socket;
	DataInputStream sin;
	DataOutputStream sout;
	String name;
	
	static LinkedList<OneClient> clients = new LinkedList<>();
	public OneClient(Socket s) {
	   socket = s;
	   try {
		sin = new DataInputStream(socket.getInputStream());
		sout = new DataOutputStream(socket.getOutputStream());
	   } catch(Exception e) {
		System.out.println("Error: " + e);
	   }
	}

	void broadcast(String msg) {
		for(OneClient c : clients) {
		   try {
			c.sout.writeUTF(msg);
		   } catch(Exception e) {
			System.out.println("Error: " + e);
		   }
		}
	}

	public void run() {
	   try {
		sout.writeUTF("Enter your name: ");
		name = sin.readUTF();
		
		clients.add(this);
		broadcast(name + " joined the chat");
		
		String msg;
		while(true) {
			msg = sin.readUTF();
			if(msg.equalsIgnoreCase("quit"))
				break;
			System.out.println(name + ": " + msg);
			broadcast(name + ": " + msg);
		}
		clients.remove(this);
		broadcast(name + " left the chat");
		socket.close();
	   } catch(Exception e) {
		System.out.println("Error: " + e);
	   }
	}
}

class ServerChat {
	public static void main(String args[]) {
	   try {
		ServerSocket ss = new ServerSocket(1234);
		System.out.println("Public Chat Server Started....");
		
		while(true) {
			Socket s = ss.accept();
			System.out.println("Clients Connected");
			OneClient client = new OneClient(s);
			client.start();
		}
	   }
	   catch(Exception e) {
		System.out.println("Error: " + e);
	   }
	}
}

