import java.io.*;
import java.util.*;

class Author {
	String aname;
	int ano;
	
	public Author() {
		aname = " ";
		ano = 0;
	}
		
	public Author(String an, int n) {
		aname = an;
		ano = n;
	}
	
	public void read() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter name and no: ");
		aname = s.nextLine();
		ano = s.nextInt();
	}
	public void disp() {
		System.out.println("Author name: " +aname);
		System.out.println("Author number: "+ano);
	}
}
class Book extends Author {
	String bname;
	float bprice;

	public Book() {
		bname = " ";
		bprice = 0;
	}
		
	public Book(String an, int n, String bn, float p) {
		super(an, n);
		bname = bn;
		bprice = p;
	}//check whether there is a statement to pass the value from the base class, if not the default constructor is executed  

	public void read() {
		super.read();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Book name and price: ");
		bname = s.nextLine();
		bprice = s.nextFloat();
	}
	public void disp() {
		super.disp();
		System.out.println("Book name: "+bname);
		System.out.println("Book price: "+bprice);
	}
}

class LibT {
	public static void main(String args[]) {
		Author a1, a2;
		Book b1, b2;
		a1 = new Author();
		a2 = new Author("Sam", 21);
		b1 = new Book();
		b2 = new Book("Arun", 24, "Guns and Gulaams", 500);
		
		
		System.out.println("Default Constructor: ");
		a1.disp();
		System.out.println("2 argument Constructor: ");
		a2.disp();
		System.out.println("Default Constructor: ");
		b1.disp();
		System.out.println("4 argument Constructor: ");
		b2.disp();
	}
}