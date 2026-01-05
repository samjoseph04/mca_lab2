import java.io.*;
import java.util.*;
class FSize {
	public static void main(String args[]) {
		Scanner s;
		String fn;
		FileInputStream fin;
		int ch, count = 0;
		s = new Scanner(System.in);
		System.out.println("Enter the filename");
		fn = s.nextLine();
		try {
			fin = new FileInputStream(fn);
			while(true) {
				ch = fin.read();
				if(ch == -1)
					break;
				count++;
				System.out.print((char)ch);
			}
			System.out.println("\nFile size : " + count);
			fin.close();
		}
		catch(Exception e) {
			System.out.println("Error " + e);
		}
	}
}