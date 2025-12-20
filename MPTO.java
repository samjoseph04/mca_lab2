import java.io.*;
import java.util.*;

class Person {
	int age;
	String name;
	public void read() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the name and age: ");
		name = s.nextLine();
		age = s.nextInt();
	}
	public void disp() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
	}
}

class Teacher extends Person {
	String subj;
	public void read() {
		super.read();
		Scanner s = new Scanner(System.in);	
		System.out.println("Enter the subject: ");
		subj = s.nextLine();
	}
	public void disp() {
		super.disp();
		System.out.println("Subject: " + subj);
	}
}

class MPTO {
	public static void main(String args[]) {
		Person p = new Person();
		Teacher t = new Teacher();
		t.read();
		t.disp();
	}
}