import java.io.*;
import java.net.*;

class ReadThread extends Thread {
	DataInputStream sin;
	
	ReadThread(DataInputStream sin) {
		this.sin = sin;
	}
	public void run() {
	   try {
		while(true) {
			System.out.println(sin.readUTF());
		}
	   }
	   catch(Exception e) {
		System.out.println("Disconnected from the server");
	   }
	}
}

class ClientChat {
	public static void main(String args[]) {
	   try {
		Socket cs = new Socket("localhost",1234);
		
		DataInputStream sin = new DataInputStream(cs.getInputStream());
		DataOutputStream sout = new DataOutputStream(cs.getOutputStream());
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(sin.readUTF());
		String name = kin.readLine();
		sout.writeUTF(name);
		
		ReadThread rt = new ReadThread(sin);
		rt.start();
	
		while(true) {
			String msg = kin.readLine();
			sout.writeUTF(msg);
			if(msg.equalsIgnoreCase("quit")) {
				cs.close();
				break;
			}
		}
	   } 	
	   catch(Exception e) {
		System.out.println("Error: " + e);
	   }
	}
}